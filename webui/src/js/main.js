var myApp = angular.module('main', ['ui.router', 'angularTrix']);

myApp.config(function($stateProvider) {
    var helloState = {
        name: 'hello',
        url: '/hello',
        template: '<h3>hello world!</h3>'
    }

    var aboutState = {
        name: 'about',
        url: '/about',
        template: '<h3>Its the UI-Router hello world app!</h3>'
    }

    var editorState = {
        name: 'editor',
        url: '/editor',
        templateUrl: 'part/new_part.html'
    }

    $stateProvider.state(helloState);
    $stateProvider.state(aboutState);
    $stateProvider.state(editorState);
});
