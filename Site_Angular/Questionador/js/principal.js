var APLICATIVO = angular.module("Questionador", ["ngRoute"]);


APLICATIVO.config(
	function ($routeProvider, $locationProvider, $httpProvider) {
		$locationProvider.html5Mode(true);

		$routeProvider
			.when("/", {
				templateUrl: "js/parciaisHttp/publicoMenu.html",
				controller: "controleEvento_Abertos"
			})
			.when("/review", {
				templateUrl: "js/parciaisHttp/publicoReview.html",
				controller: "controleReview_Novo"
			})
			.when("/evento", {
				templateUrl: "js/parciaisHttp/publicoEvento.html",
				controller: "controleEvento_Novo"
			})
			//			.when("/administracao", {
			//				templateUrl: "js/parciaisHttp/administracaoMenu.html",
			//				controller: "controleAdministracao_Menu"
			//			})
			.when("/administracao/review", {
				templateUrl: "js/parciaisHttp/administracaoMenu.html",
				controller: "controleAdministracao_Menu"
			})



		.otherwise({
			redirectTo: "/"
		});

	});


APLICATIVO.run(
	function ($rootScope) {
		$rootScope.UrlPublico = function (pUrl) {
			return "" + pUrl;
		}


		$rootScope.UrlAdministracao = function (pUrl) {
			return "administracao/" + pUrl;
		}


		$rootScope.PublicoWS = function (pUrl) {
			return "http://localhost:9999/" + pUrl;
		}


		$rootScope.AdministracaoWS = function (pUrl) {
			return "http://localhost:9999/AdministracaoWS/" + pUrl;
		}


		$rootScope.LogItem = function (pTitulo, pTexto) {
			if (pTitulo.indexOf("*****") < 0) {
				pTitulo = "     " + pTitulo;
			}
			console.log(pTitulo + ": '" + pTexto + "'");
		}


		$rootScope.ObterDados = function ($scope, $http, pUrl, pBD) {
			var SucessoCallback = function (pRetorno) {
				$scope[pBD] = pRetorno.data;
				$rootScope.LogItem("********** SUCESSO em ObterDados (GET) do WebService", pUrl);
				var vDados = JSON.stringify(pRetorno.data, null, 4);
				//vDados = vDados.replace(/,/g, ",</li><li>");
				//vDados = vDados.replace(/{/g, "{<ul><li>");
				//vDados = vDados.replace(/}/g, "</li></ul>}");
				//vDados = vDados.replace(/\[/g, "[<ol><li>");
				//vDados = vDados.replace(/\]/g, "</ol></li>]");
				$rootScope.LogItem("Variável '" + pBD + "'", vDados);
			}

			var FalhaCallback = function (pRetorno) {
				$rootScope.LogItem("********** FALHA em ObterDados (GET) do WebService", pUrl);
				$rootScope.LogItem("Error", pRetorno.error);
				$rootScope.LogItem("Status", pRetorno.status);
				$rootScope.LogItem("StatusText", pRetorno.statusText);
			}


			$scope[pBD] = null;
			$http.get(pUrl).then(SucessoCallback, FalhaCallback);
		}


		$rootScope.EnviarDados = function ($scope, $http, pUrl, pBD) {
			var SucessoCallback = function (pRetorno) {
				$scope[pBD] = pRetorno.data;
				$rootScope.LogItem("********** SUCESSO em EnviarDados (POST) do WebService", pUrl);
				var vDados = JSON.stringify(pRetorno.data);
				vDados = vDados.replace(/,/g, ",</li><li>");
				vDados = vDados.replace(/{/g, "{<ul><li>");
				vDados = vDados.replace(/}/g, "</li></ul>}");
				vDados = vDados.replace(/\[/g, "[<ol><li>");
				vDados = vDados.replace(/\]/g, "</ol></li>]");
				$rootScope.LogItem("Variável '" + pBD + "'", vDados);
			}

			var FalhaCallback = function (pRetorno) {
				$rootScope.LogItem("********** FALHA em EnviarDados (POST) do WebService", pUrl);
				$rootScope.LogItem("Error", pRetorno.error);
				$rootScope.LogItem("Status", pRetorno.status);
				$rootScope.LogItem("StatusText", pRetorno.statusText);
				$rootScope.LogItem("Variável '" + pBD + "'", JSON.stringify($scope[pBD], null, 4));
			}


			$http.post(pUrl, $scope[pBD]).then(SucessoCallback, FalhaCallback);
		}
	}
);


/* 
 * 
 * function JsonParaData(_DataJson) { return new
 * Date(parseInt(_DataJson.substr(6))); }
 * 
 * function JsonFormatoData(_DataJson) { var vData = new
 * Date(JsonParaData(_DataJson)); return vData.toLocaleDateString(); }
 */
