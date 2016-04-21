var app = angular.module('MyApp', [])
app.controller('MyController', function ($scope) {
    //This will hide the DIV by default.
    $scope.IsVisible = false;

    $scope.ShowHide = function () {
        //If DIV is visible it will be hidden and vice versa.
        $scope.IsVisibleTravel = $scope.ShowTravelKeys;
        $scope.IsVisibleSports = $scope.ShowSportsKeys;
        $scope.IsVisibleFinance = $scope.ShowFinanceKeys;
        $scope.IsVisibleFood = $scope.ShowFoodKeys;
        $scope.IsVisibleShopping = $scope.ShowShoppingKeys;
    }
});