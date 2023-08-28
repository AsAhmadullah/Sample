Feature:  Functionality Check - Thiagarajar College Website

Scenario: Login

Given user Navigates to The TC Website
When user Enters The Username And Password
Then user Clicks The Signin Button And Navigate To The Dashboard Page

Scenario: Dashboard

When user Click Settings Option On The Dashboard
And user Click On The Canteens Option From The Dropdown
Then user Click On New To Create A New Canteen From The Canteen List

Scenario: Add New Canteen 

When user Enters The Canteen Name And Then user Enters The Canteen Code
And user Click On The Save Button And Navigates To The Canteen List Page
Then user Click On The Close Button of The Popup Alert 

Scenario: Search And Validate Canteen 

When user Enters The Canteen Name In The Search Box
Then user Validates The Canteen Name

Scenario: Edit Canteen

When user Clicks The Edit Button
And user Clears the Canteen Name And Enters The New Name
Then user Submits By Clicking The Save Button And Close The Popup Alert

Scenario: Search And Validate Canteen 

When user Clears The Previous Canteen Name In The Search Box 
And user Clicks On The Refresh Button From The Canteen List
Then user Enter a Canteen Name In The Search Box TO Validate The Canteen Name

Scenario: Delete Canteen

When user Clicks The Delete Button
And user Clicks On The Delete It Button IN The Alert Box
Then user Clicks The OK Button In The Alert Box

Scenario: Logout

When user Clicks On The User ID
Then user Clicks on the Logout Button
Then user Quits The Browser



