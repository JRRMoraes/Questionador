APLICATIVO.directive("cabecalho",
	function () {
		return {
			restrict: "E",
			scope: {
				classe: "@",
				subtitulo: "@"
			},
			templateUrl: "js/diretivasHttp/cabecalho.html"
		};
	});


APLICATIVO.directive("rodape",
	function () {
		return {
			restrict: "E",
			templateUrl: "js/diretivasHttp/rodape.html"
		};
	});


APLICATIVO.directive("editorTexto",
	function () {
		return {
			restrict: "E",
			transclude: true,
			scope: {
				nome: "@",
				campo: "="
			},
			templateUrl: "js/diretivasHttp/editorTexto.html"
		};
	});


APLICATIVO.directive("radioSelecaoExcelenteARuim",
	function () {
		return {
			restrict: "E",
			transclude: true,
			scope: {
				nome: "@",
				campo: "="
			},
			templateUrl: "js/diretivasHttp/radioSelecaoExcelenteARuim.html"
		};
	});
