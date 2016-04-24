
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
        });
       
    // catch all route
    // send users to the form page 
    $urlRouterProvider.otherwise('/form/target');
})

// our controller for the form
// =============================================================================
.controller('formController', function($scope) {
    
    // we will store all of our form data in this object
    $scope.audience = {"kids":false,"teens":false,"adults":false,"elderly":false};
    $scope.category = {"travel":false,"fitness":false,"social":false,"productivity":false,"media":false,"finance":false,"shopping":false,"education":false};
    $scope.keywords = {"trasportation":false,"lodging":false,"attractions":false,"running":false,"diet":false,"workout":false,"chat":false,"professional":false,"dating":false,"note":false,"list":false,"calendar":false,"banking":false,"investments":false,"budge":false,"clothing":false,"home":false,"electronics":false,"music":false,"video":false,"photo":false,"study":false,"learn":false,"reference":false};
    $scope.comments = "";
    $scope.SelectedLogo = 0;

    $scope.completed = function (obj) {
        var keys = Object.keys(obj);
        return keys.map(function (key) {
            return obj[key];
        }).filter(function (value) {
            return value;
        }).length > 0;
    };

    $scope.nothing = function () {

    };

    // function to process the form
    $scope.processForm = function() {
        alert('Submitted');  
    };

    $scope.serverResponse = [
    {
        "_font": "Chewy",
        "_size": "big",
        "_image": "map.png",
        "_title": "startr"
    }
    ];

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
    
});

