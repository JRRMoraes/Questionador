APLICATIVO.controller("controleEvento_Abertos",
	function ($rootScope, $scope, $http) {
		$rootScope.ObterDados($scope, $http, $rootScope.PublicoWS("evento/abertos"), "bdEVENTOS");
	});


APLICATIVO.controller("controleReview_Novo",
	function ($rootScope, $scope, $http) {
		$rootScope.ObterDados($scope, $http, $rootScope.PublicoWS("review/novo"), "bdREVIEW");

		$scope.SalvarReview = function () {
			$rootScope.EnviarDados($scope, $http, $rootScope.PublicoWS("review/salvar"), "bdREVIEW");
		}
	}
);


APLICATIVO.controller("controleEvento_Novo",
	function ($rootScope, $scope, $http) {
		$rootScope.ObterDados($scope, $http, $rootScope.PublicoWS("evento/novo"), "bdEVENTO"); ///  evento/{{idEvento}}/questionarioNovo

		$scope.SalvarEvento = function () {
			$rootScope.EnviarDados($scope, $http, $rootScope.PublicoWS("evento/salvar"), "bdEVENTO");
		}
	}
);
