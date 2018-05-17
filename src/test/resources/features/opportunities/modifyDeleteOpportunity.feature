Feature: Opportunity features

Background: User is logged in the application
Given Open the Firefox and launch the application enter the Username and Password and press login
When I login to the application
And I can go to opportunity section
And I can create a new opportunity
And I can create a new opportunity fill the fields and press the save button
| OPPORTUNITY_NAME       | Mora        |
| OPPORTUNITY_CLOSE_DATE | 17/05/2018  |
| OPPORTUNITY_STAGE      | Prospecting |

Scenario: Edit opportunity with all fields filled
Given I can go to opportunity section
When I choose an opportunity and press the edit button
And I can create a new opportunity fill the fields and press the save button
| OPPORTUNITY_NAME       | Coco        |
| OPPORTUNITY_CLOSE_DATE | 18/05/2030  |
| OPPORTUNITY_STAGE      | Prospecting |
Then I can verify the new opportunity "Coco"

Scenario: Delete opportunity
Given I can go to opportunity section
When I choose an opportunity and press the delete button
Then I can verify that the opportunity was deleted