
// create our angular app and inject ngAnimate and ui-router 
// =============================================================================
angular.module('formApp', ['ngAnimate', 'ui.router'])

// configuring our routes 
// =============================================================================
.config(function($stateProvider, $urlRouterProvider) {
    
    $stateProvider
    
        // route to show our basic form (/form)
        .state('form', {
            url: '/form',
            templateUrl: 'form.html',
            controller: 'formController'
        })
        
        // nested states 
        // each of these sections will have their own view
        // url will be nested (/form/target)
        .state('form.target', {
            url: '/target',
            templateUrl: 'form-target.html'
        })
        
        // url will be /form/category
        .state('form.category', {
            url: '/category',
            templateUrl: 'form-category.html'
        })
        
        // url will be /form/keywords
        .state('form.keywords', {
            url: '/keywords',
            templateUrl: 'form-keywords.html'
        })

        // url will be /form/comments
        .state('form.comments', {
            url: '/comments',
            templateUrl: 'form-comments.html'
        })

        // url will be /form/logo
        .state('form.logo', {
            url: '/logo',
            templateUrl: 'form-logo.html'
        })

        // url will be /form/comments
        .state('form.summary', {
            url: '/summary',
            templateUrl: 'form-summary.html'
        });
       
    // catch all route
    // send users to the form page 
    $urlRouterProvider.otherwise('/form/target');
})

// our controller for the form
// =============================================================================
.controller('formController', function($scope, $http, $state) {
    
    var default_audience = {"kids":false,"teens":false,"adults":false,"elderly":false};
    var default_category = {"travel":false,"fitness":false,"social":false,"productivity":false,"media":false,"finance":false,"shopping":false,"education":false};
    var default_keywords = {"transportation":false,"lodging":false,"attractions":false,"running":false,"diet":false,"workout":false,"chat":false,"professional":false,"dating":false,"note":false,"list":false,"calendar":false,"banking":false,"investments":false,"budget":false,"clothing":false,"home":false,"electronics":false,"music":false,"video":false,"photo":false,"study":false,"learn":false,"reference":false};

    // we will store all of our form data in this object
    $scope.audience = angular.copy(default_audience);
    $scope.category = angular.copy(default_category);
    $scope.keywords = angular.copy(default_keywords);
    $scope.comments = "";
    $scope.SelectedLogo = -1;

    $scope.selectLogo = function (idx) {
        $scope.SelectedLogo = idx;
    }

    $scope.completed = function (obj) {
        var keys = Object.keys(obj);
        return keys.map(function (key) {
            return obj[key];
        }).filter(function (value) {
            return value;
        }).length > 0;
    };

    $scope.startOver = function() {
        $scope.audience = angular.copy(default_audience);
        $scope.category = angular.copy(default_category);
        $scope.keywords = angular.copy(default_keywords);
        $scope.comments = "";
    }

    $scope.getLogo = function() {
        $http({
            method  : 'POST',
            url     : 'http://startr.mybluemix.net/processData',
            data    : {
                "target"   : $scope.audience,
                "category" : $scope.category, 
                "keywords" : $scope.keywords, 
                "comments" : $scope.comments }
        })
        .success(function(data) {
            console.log(data);

            // if (!data.success) {
            //     $scope.errorlogo = data.errors.logo;
            // }
            // else {
                $scope.serverResponse = data.results;
                $scope.serverAnalysis = data.analysis;

                $scope.styles = $scope.serverResponse.map(function (value) {
                    var sizes = {
                        "small": 30,
                        "normal": 40,
                        "big": 60
                    };

                    return {
                        "font-family" : value._font,
                        "font-size" : sizes[value._size] + "px"
                    };
                }); 

                $state.go('form.logo')

            // }
        }); 
    }

    //function to process the form
    $scope.processForm = function() {

    };

});

