
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
    $scope.formData = {};
    $scope.audience = {};
    $scope.category = {};
    $scope.keywords = {};
    
    $scope.avatarData = [{
    id: "avatars:svg-1",
    title: 'avatar 1',
    value: 'avatar-1'
    },{
    id: "avatars:svg-2",
    title: 'avatar 2',
    value: 'avatar-2'
    },{
    id: "avatars:svg-3",
    title: 'avatar 3',
    value: 'avatar-3'
    }];
    
    // function to process the form
    $scope.processForm = function() {
        alert('awesome!');  
    };
    
});

