$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/account.feature");
formatter.feature({
  "name": "Accounts feature",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "User is logged in the application",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Open the Firefox and launch the application",
  "keyword": "Given "
});
