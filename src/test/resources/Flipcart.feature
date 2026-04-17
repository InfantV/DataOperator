Feature: Flipkart

Background:
Given User opens flipkart browser

@smoke
Scenario: Mobile Search and add to cart 
When User searches Realme mobile
And clicks the second mobile from the options
And add the mobile to cart
Then User takes screenshot of the cart page

Scenario: Mobile Search and add to cart using one dim List 
When User searches mobile by using one dimensional list
|Samsung|
|Iphone|
And clicks the second mobile from the options
And add the mobile to cart
Then User takes screenshot of the cart page

Scenario: Mobile Search and add to cart using one dim Map 
When User searches mobile by using one dimensional map
|phone1|Samsung|
|phone2|Iphone|
|phone3|Redmi|
And clicks the second mobile from the options
And add the mobile to cart
Then User takes screenshot of the cart page

Scenario Outline: All mobile Search and add to cart 
When User searches mobile "<phones>"
And clicks the second mobile from the options
And add the mobile to cart
Then User takes screenshot of the cart page

Examples:
|phones|
|Realme|
|Iphone|
|Redmi|