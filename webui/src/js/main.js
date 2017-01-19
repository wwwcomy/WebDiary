var myApp = angular.module('main', ['ui.router', 'angularTrix']);

myApp.config(function($stateProvider) {

    var mainState = {
        name: 'main',
        url: '',
        views: {
            '': {
                templateUrl: 'part/inner_main.html'
            },
            'treeState@main': {
                name: 'tree',
                url: '/editor',
                templateUrl: 'part/tree.html'
            },
            'editorState@main': {
                name: 'editor',
                url: '/editor',
                templateUrl: 'part/new_part.html'
            }
        }
    };

    $stateProvider.state(mainState);
});
