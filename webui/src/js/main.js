var myApp = angular.module('main', ['ui.router', 'angularTrix', 'angularBootstrapNavTree']);

myApp.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');

        var mainState = {
            name: 'main',
            url: '',
            views: {
                '': {
                    templateUrl: 'part/inner_main.html'
                },
                'treeState@main': {
                    name: 'tree',
                    templateUrl: 'part/tree.html',
                    controller: 'treeController'
                }
            }
        };
        var test1 = {
            name: 'main.test1',
            template: '<div>this is the test1 template</div>'
        }
        var test2 = {
            name: 'main.test2',
            template: '<div>this is the test2 template</div>'
        }
        var editorState = {
            name: 'main.editorState',
            templateUrl: 'part/new_part.html'
        }

        $stateProvider.state(mainState);
        $stateProvider.state(test1);
        $stateProvider.state(test2);
        $stateProvider.state(editorState);
    }])
    .controller("treeController", function treeController($scope, $state) {
        $scope.getDiaryDetail = function(branch) {
            $state.go(branch.data.description);
            console.log(branch);
        };
        $scope.diaryDates = [{
            label: 'Languages',
            children: [{
                label: 'Java',
                data: {
                    description: "main.test1"
                }
            }, {
                label: 'Javascript',
                data: {
                    description: "main.test2"
                }
            }, {
                label: 'C#',
                data: {
                    description: "Microsoft"
                }
            }]
        }];
    });
