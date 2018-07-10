APLICATIVO.controller("controleEvento_Abertos",
	function ($rootScope, $scope, $http) {
		$rootScope.ObterDados($scope, $http, $rootScope.ServicoFuncao("eventos", "abertos"), "bdEVENTOS");
	});


APLICATIVO.controller("controleReview_Novo",
	function ($rootScope, $scope, $http) {
		$rootScope.ObterDados($scope, $http, $rootScope.ServicoFuncao("reviews", "novo"), "bdREVIEW");

		$scope.SalvarReview = function () {
			$rootScope.EnviarDados($scope, $http, $rootScope.Servico("reviews"), "bdREVIEW"); // post put
		}
	}
);


APLICATIVO.controller("controleEvento_Novo",
	function ($rootScope, $scope, $http) {
		$rootScope.ObterDados($scope, $http, $rootScope.ServicoFuncao("eventos", "novo"), "bdEVENTO"); ///  evento/{{idEvento}}/questionarioNovo

		$scope.SalvarEvento = function () {
			$rootScope.EnviarDados($scope, $http, $rootScope.Servico("eventos"), "bdEVENTO"); //put post
		}
	}
);
