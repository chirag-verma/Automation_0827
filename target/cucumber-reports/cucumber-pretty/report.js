$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Feature/Manager.feature");
formatter.feature({
  "line": 1,
  "name": "Manager functionalities",
  "description": "",
  "id": "manager-functionalities",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "Launch the browser",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "User Launch Chrome Browser",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User enter the the MeerQATS login page",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "After Verifying login page title",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Manager enters Username and Password and click login",
  "keyword": "And "
});
formatter.match({
  "location": "Step.User_Launch_Chrome_Browser()"
});
formatter.result({
  "duration": 4864451600,
  "status": "passed"
});
formatter.match({
  "location": "Step.User_enter_the_the_MeerQATS_login_page()"
});
formatter.result({
  "duration": 3581344400,
  "status": "passed"
});
formatter.match({
  "location": "Step.After_Verifying_login_page_title()"
});
formatter.result({
  "duration": 131272100,
  "status": "passed"
});
formatter.match({
  "location": "Step.Manager_enters_Username_and_Password_and_click_login()"
});
formatter.result({
  "duration": 16401342700,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "Verify Workbaskets and case status",
  "description": "",
  "id": "manager-functionalities;verify-workbaskets-and-case-status",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 34,
      "name": "@Fifth"
    }
  ]
});
formatter.step({
  "line": 36,
  "name": "Manager Goes to Dashboard",
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "Manager click on Quality Review Work Queue and validate case status for any case",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "Manager Goes to Dashboard",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "Manager click on Pending Vital Records and validate case status for any case",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "Manager Goes to Dashboard",
  "keyword": "When "
});
formatter.step({
  "line": 41,
  "name": "Manager click on Awaiting Action Queue and validate case status for any case",
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "Manager Goes to Dashboard",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "Manager click on Documents Available Queue and validate case status for any case",
  "keyword": "Then "
});
formatter.step({
  "line": 44,
  "name": "Manager Goes to Dashboard",
  "keyword": "When "
});
formatter.step({
  "line": 45,
  "name": "Manager click on Awaiting Action Release and validate case status for any case",
  "keyword": "Then "
});
formatter.step({
  "line": 46,
  "name": "Manager Goes to Dashboard",
  "keyword": "When "
});
formatter.step({
  "line": 47,
  "name": "Manager click on Provisional Pending Definitive Queue and validate case status for any case",
  "keyword": "Then "
});
formatter.match({
  "location": "Step.Manager_Goes_to_Dashboard()"
});
formatter.result({
  "duration": 6210761100,
  "status": "passed"
});
formatter.match({
  "location": "Step.Manager_click_on_Quality_Review_Work_Queue_and_validate_case_status_for_any_case()"
});
formatter.result({
  "duration": 15430057000,
  "status": "passed"
});
formatter.match({
  "location": "Step.Manager_Goes_to_Dashboard()"
});
formatter.result({
  "duration": 6332018000,
  "status": "passed"
});
formatter.match({
  "location": "Step.Manager_click_on_Pending_Vital_Records_and_validate_case_status_for_any_case()"
});
formatter.result({
  "duration": 14564283000,
  "status": "passed"
});
formatter.match({
  "location": "Step.Manager_Goes_to_Dashboard()"
});
formatter.result({
  "duration": 6239339400,
  "status": "passed"
});
formatter.match({
  "location": "Step.Manager_click_on_Awaiting_Action_Queue_and_validate_case_status_for_any_case()"
});
formatter.result({
  "duration": 15214904200,
  "status": "passed"
});
formatter.match({
  "location": "Step.Manager_Goes_to_Dashboard()"
});
formatter.result({
  "duration": 6196866800,
  "status": "passed"
});
formatter.match({
  "location": "Step.Manager_click_on_Documents_Available_Queue_and_validate_case_status_for_any_case()"
});
formatter.result({
  "duration": 15545837600,
  "status": "passed"
});
formatter.match({
  "location": "Step.Manager_Goes_to_Dashboard()"
});
formatter.result({
  "duration": 6195798500,
  "status": "passed"
});
formatter.match({
  "location": "Step.Manager_click_on_Awaiting_Action_Release_and_validate_case_status_for_any_case()"
});
formatter.result({
  "duration": 14274051000,
  "status": "passed"
});
formatter.match({
  "location": "Step.Manager_Goes_to_Dashboard()"
});
formatter.result({
  "duration": 6131125900,
  "status": "passed"
});
formatter.match({
  "location": "Step.Manager_click_on_Provisional_Pending_Definitive_Queue_and_validate_case_status_for_any_case()"
});
formatter.result({
  "duration": 14643291900,
  "status": "passed"
});
formatter.after({
  "duration": 8965667200,
  "status": "passed"
});
});