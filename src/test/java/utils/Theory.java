//package utils;
//
//public class Theory {
//
//    SELENIUM: 2/11/2023
//
//            1-What is Selenium?
//
//            -->Selenium is a web automation tool. (UI -->User interface)
//
//    NOTE1: Selenium automates web browsers(Chrome,Safari,Microsoft Edge, Firefox)
//
//**Web Application --> Website(amazon, ebay,facebook, yahoo, etc) -->We use Selenium
//**Desktop Application --> intelliJ, sublime, zoom, slack -->we do not use Selenium
//**Mobile Application -->iOS,Android --> Appium --> We do not use Selenium
//
//1- Interview Question:
//            *** What is the advantage and disatvantage of using Selenium?
//
//    Selenium disatvantages:
//            1-Selenium cannot automate the captcha, pictures, QR code, Scanner etc...
//            2-Selenium has not Customer Service
//  3-Selenium does not have Reporting System
//  4-Selenium automates ONLY web applicaton
//
//    Selenium advantages:
//            1-Selenium is a free-open source tool
//  2-Selenium has a big community(*)
//  3-Selenium supports multiple browsers(Chrome, Firefox,Safari)
//  4-Selenium supports multiple language(Java,////phyton,JavaScript,C# etc)
//
//--> What are the types of Selenium?
//                                                1-Selenium RC(Remote Control)=>The applicaton is stored in server and automation happens in the same server as well
//  2-Selenium IDE(Integrated Development Environment)->Is primarly record/run
//  *** 3-Selenium WebDriver -> It is a library that we can add to our project(java)
//  4-Selenium Grid --> All about paralell testing.
//    exp: 1500 test cases --> 3 :25  hours it was running from one machine
//  		5 Threads --> 300 300 300 300 300  --> 55 min -75 min
//    Lets start some coding in intelliJ
//  1-Click File --> New-->Project
//  2-Pick Maven from the list of and give a name then click the Next
//  3-Drag and drop resources folder into test, delete main folder
//  4-Add Selenium library into the Pom.xml
//  5-Get the dependency(library) from MVN
//  6-Copy and paste under the POM.xml file
//
//
//
//    RECAP: 2/12/2023
//
//    Selenium --> Is an automation tool (UI --> User interface)
//
//-->You can only automate Web Application
//-->Selenium-Java dependency --> library --> MVN repository (we download from)
//-->ChromeDriver --> it is a way to setup your web browser
//      System.setProperty("webdriver.chrome.driver","chromedriver.exe")
//              -->geckodriver --> Firefox ( it is a way to setup your Firefox browser)
//      System.setProperty("webdriver.firefox.driver","geckodriver.exe") *** Only interview purposes
//--> WebDriver (interface) driver(reference) = new(refering new Object) ChromeDriver(type of web browser)
//  --> Where do you use Polymorphism in your project? --> WebDriver driver = new ChromeDriver();
//                                                     --> ChromeDriver driver = new ChromeDriver();
//  --> WebDriver driver = new WebDriver(); --> You cannot do it since you cannot create an object from interface() (ghost class);
//
//    INTERVIEW Question:
//            1-What is the functionality of driver? and how do you create it?
//            -->Driver is way to manipulate data on the web browser. In other words, It is a way to make a connection between
//    your system to web browser to make som changes(validation) you want
//
//    Driver Methods: driver.(it means youre using driver methods)
//            -->driver.get("URL"); --> it will take you to the url that you provide
//  -->driver.getTitle(); --> It returns String and it gets the title of the website.(we use it mostly for validation to make sure we are on the correct page)
//
//    SUMMARY OF THE DAY:
//
//            1-Driver Methods: WebDriver driver = new ChromeDriver();
//    *driver.get() --> take you to the website
//    *driver.navigate.to() -->take you to the website
//    *driver.navigate.back() --> take you to the previous page
//    *driver.navigate.forward(); --> take you to the next page
//    *driver.navigate.refresh(); --> refresh the current page
//    *driver.manage.windows.maximize(); --> it maximizes the screen
//    *driver.close();--> it closes the current page
//    *driver.quit(); --> it closes all the opened page from automation
//    *driver.getPageSource(); --> it will give you the html source of the page
//    *driver.getTitle(); -->it will get the title of the page
//    *driver.getCurrentUrl(); --> it will get the current URL
//    *driver.findElement(); --> it will find the element from page
//
//  2-WebElements Methods: WebElement element = driver.findElement(By.anytype("value"))
//
//            *element.getText(); --> it gives you text of the element
//    *element.sendKeys()--> it sends the data to the box. (rememeber information boxes example)
//            *element.click() --> it clicks the element (make sure element is clickable)
//    *element.isDisplayed() --> it returns boolean --> it checks the elements is on the page or not.
//            *element.isSelected() --> it returns boolean --> it checks the element is selected or not.
//
//            3-LOCATORS:  By id, By Name, By className, By TagName
//
//    *ID --> WebElement element = driver.findElement(By.id("Value"))
//            *NAME --> WebElement element2 = driver.findElement(By.name("namevalue"))
//            *CLASSNAME --> WebElement element3 = driver.findElement(By.className("classvalue"))
//            *TAGNAME --> WebElement element4 = driver.findElement(By.TagName("TAGNAME"))
//
//
//    Questions for Ahmet.
//            getPageSource .. why we need it? and where we could use it?
//
//
//    RECAP: 2/14/2023
//
//            --> Having automation is skill is one of the important skills that we should have
//    -->UI (User Interface)     ->API (backhand)
//  -->The reason we should know automation and not get hired as MANUAL TESTER
//    -->SDET
//      -->They have lots of respect from other teams
//      -->Reduce the work load of the team --> being respect
//      -->Reduce the amount of budget for company --> bring respect
//      -->You will reduce your workload and reuse the automation script everytime
//        -->one time implement, use multiple times
//  -->Selenium --> Is UI automation tool --> Web browser
//      1-->System.setProperty --> Setup your chromedriver for automation
//      2-->WebDriver driver = new ChromeDriver() --> Polymorphism(OOP)
//            -->manipulate data on the website
//       -->make a connection between website and computer
//      3-->driver.navigate or get --> take you to the website
//      4-->Starting finding the elements from the website for the manipulation
//       -->driver.findElement(By.name),By.class , By.id,By.TagName
//      5-->You use some WebElements methods to do more manipulation:
//            -->GetText()            -->IsDisplayed();
//        -->SendKeys()           -->isSelected();
//        -->Click()
//
//      -->THIS AUTOMATION LOGIC WILL NOT CHANGE, BUT THE WAY OF IMPLEMENTATION WILL BE ADVANCE EACH LEVEL
//
//      -->XPATH  = is the most useful and advance level of locator to find the element
//
//    We have 2 types of xPath:
//            1-Absolute Xpath : is a way to find element from all the way parent to all the way child
//            -->EARTH / USA / IL / Cook County / CHICAGO / 2200 Techtorial
//            -->html/div/a/h1 --> Parent-child --> all the way top to bottom
//            *NOTE: (it  starts with single slash)
//
//            2-Relative Xpath : It is a way to find the elment from directly to child or parent-child
//            -->2200 Techtorial
//            -->//TagName[@attribute='AttributeValue']; -->this is for attributes
//                    -->//TagName[contains(text(),'TextValue')]; -->This is for text
//                    -->//TagName[.='TextValue']; --> This is for text but it must match 100% of the text
//                    *NOTE: it starts with DOUBLE slash
//
//    INTERVIEW QUESTIONS:
//            1-What is the difference between driver.get() and driver.navigate().to() ?
//            Driver.get("URL"): * Whenever it goes to the website, it "Waits for all elements to be loaded"
//            * does not have methods
//    Driver.navigate().to("URL"): *Whenever it goes to the website, it "Waits for certain elements that you are looking for"
//            *Has methods(forward,to,back,refresh)
//  2-What are the locator do you use for automation?
//            -->ID -->NAME --> CLASSNAME -->TAGNAME -->LINKTEXT -->PARTIALLINKTEXT --> CSS --> XPATH
//  3-What kind of exception do you face during automation and how do you handle it?
//            -->NOSUCHELEMENT EXCEPTION : is the most common exception in UI automation
//    -FOLLOW THESE STEPS IF YOU ARE HAVING NO SUCH ELEMENT EXCEPTION:
//            1-Verify that Exception type is NOSUCHELEMENT EXCEPTION FROM CONSOLE
//    2-Click the number of line(blue line) on console to see the location of failure
//    3-Now you found the problem: Lets solve it
//      -->Copy your value and check that the value is still giving 1 of 1 on the website
//      -->If yes, it means your value is good then check your locator tyoe(id,xpath,tagname ...)
//      -->If no, it means the value is changing(dynamic) the go with different attributes
//      -->If still failing:
//            -->Maximize your screen
//        -->Put Thread.sleep before the failing line. Lets say line 23 is failing then put Thread.sleep for line 22 or before
//        -->Here is the suggested rank for usage of locator:
//            1-->Look fo ID attribute
//          2-->Look for Name attribute
//          3-->Look for XPATH attribute
//            -->Relative Xpath
//              -->//TagName[@attribute='AttributeValue'];
//                      -->//TagName[contains(text(),'TextValue')];
//                      -->//TagName[.='textValue'];
//                      -->//TagName[contains(@attribute,'part of AttributeValue')
//
//                      **NOTE: IF STILL NOT WORKING THEN CONTACT WITH TECHNICAL SUPPORT OR MR.AHMET
//
//    -->INVALIDSELECTOR EXCEPTION --> It is all about the structure of Locator value
//      -->Please make sure you do not forget 'quotation' and [bracket] or slashes //
//
//  4-What is XPATH and how many types do you know? (Which Xpath do you use and why) ?
//    Xpath is an advance version of finding the elements in Selenium
//     -->Absolute Xpath -->which goes from all the way parent to child (/html/div[2]/a/p)
//     -->Relative Xpath -->which goes to mostly directly to the child (//div[@id='Ahmet'])
//
//  5-Can you tell me 5 DriverMethods and 5 WebElements methods?
//                                                                              -->Driver Methods --> get(), manage(), driver(), close(), getTitle(), quit(), getCurrentUrl(), navigate.to()
//      -->WebElement Methods --> getText(), sendKeys(), click(), isSelected, isDisplayed
//  6-What is the difference between driver.close and driver.quit()?
//
//    NOTE: ImplicitlyWait: It is a wait time that wait for specific elements for certain amount of time
//        driver.manage.timeots.ImplicitlyWait(Duration.ofSecond(10))-->it will wait extra 10 seconds for elements to be loaded if it doesnt.
//
//
//    HOMEWORK --> GO TO https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html
//            -->Click all the boxes when aria-label is false (Think about getAttribute method)
//
//
//    RECAP: 2/18/2023
//
//    INTERVIEW QUESTIONS:
//
//            1-What is the difference between GetText and GetAttribute ?
//            -->Both of them are really useful WebElement methods.
//    GetText --> It is all about getting text from the element
//            -->GetText methods gets the only text which is not connected with any attribute(usually black)
//               -->exp: <div id="Ahmet" class="Baldir">Hello IT people </div>/
//    tagName = div , attributes ==> id and class ... text ==> Hello IT people
//               "Ahmet" is the Id attribute value, "Baldir" is the class attribute value
//
//            GetAttribute -->it is all about getting the "attribute value" from the element
//                 -->element.getAttribute("id") -->Ahmet
//                 -->element.getAttribute("class") --> Baldir
//
//  2-What is the difference between findElement and findElements?
//
//    FindElement: It is a way to find the element from website(It stores only one element)
//    ex: WebElement element = driver.findElement(By.xpath"//div")
//            -->When find element method fails, it throws "NOSUCHELEMENT" exception
//    FindElements : It is a way to find the elements from website (IT is used to store more than one element)
//    ex: List<WebElement> elements = driver.findElements(By.name("boxes"))
//            -->When find elements fails, it will return an empty list( it doesnt throw any exceptions)
//
//    NOTE: How can we use findElements method
//        1-We need to iterate each element from List WebElement
//    ex:
//            for(WebElement box : boxes){
//        if(box.isDisplayed && !box.isSelected && box.isEnabled){
//            box.click();
//        }
//    }
//
//
//
//    CSS LOCATOR: Is one of the locators to find the element in Selenium. I personaly prefer usng it
//    because it is really simple to implement.
//
//  --> There are two ways of implememnting CSS selector
//
//    -->ID --> To be able to use ID attribute in CSS Selector, we need to add "#" at the beginning
//
//    exp: WebElement element = driver.findElement(By.cssSelector("#idValue"))
//
//            -->Class --> To be able to use Class attribute in CSS Selector, we need to add "." at the beginning
//
//    exp: WebElement element = driver.findElement(By.cssSelector(".classValue"))
//
//    INTERVIEW QUESTION:
//
//            1 - What do you know about Selenium locators? Which one you use the most in your project?
//
//            -->ID --> Name --> ClassName --> TagName --> LinkText --> PartialLinkText --> CssSelector --> XPATH
//
//  --> I personaly prefer to use XPATH, even though I know id and CSS are faster than XPATH
//
//  --> But the reason I prefer XPATH because it has lots of ways to locate the unique elements.findElement
//
//    --> contains,".",StartsWith, EndsWith, following-siblings, precending sibings
//
//    LEVEL 1
//            ==========================================================================================================
//    Level 2
//
//    TESTING:
//
//            1-What is TestNG?
//
//            -->It is a framework which has library and some annotations,methods, keywords
//
//-->It is a way to VALIDATE our test cases.
//
//2-Why do we need TestNG?
//
//            -->To be able to make your framework more organize and proffesional, we apply TestNG library.
//            -->We can use @Test annotations from TestNG tool instead of main method. It means you do not need main method anymore
//
//3-What is the advantage of TestNG?
//            -->It gives you a lot of code efficiency, structured code, clear, understandable and being more professional for UI automation.
//
//    WebDriverManager:
//    It is a way to setup your automation quickly. It means you do not need System.setProperty
//    anymore. The reason we use WebDriverManager because it is all the time up to date and it does not work with Chrome version.
//
//
//    RECAP:2/19/2023
//
//            -->Became lvl 2--> Congrats
//
//  -->Downloading 2 dependencies(library) -->methods, annotations (@Test,Assert,priority,invocationCount)
//    -->TestNG: is a framework
//      -->@Test --> is all about executing the test.(kind of main method). The benefit of using @Test instead of main method.
//    You can have as many @Test as you want in same class.
//            -->priority-->it will change the execution order in project
//    ex:@Test(priority=1)
//      -->invocationCount --> it will run the same @Test as many times as you want
//    ex:@Test(invocationCount = 20) --> it will run 20 times
//    NOTE: Where I use this is creating/population mock data for my testing.(20 customers for testing)
//            *-->Assertion-->It is all about validating the data in a professional way.
//            note: You need to import Assert from testNG
//        -->Assert.assertEquals(actual,expected);
//        *//this will compare the actual and expected, if it fails, it will show you why they are failing
//                -->Assert.assertTrue(boolean condition);
//        *//this will check the condition is true or false --> if its true, your test will pass
//    ex:Assert.assertTrue(element1.contains(element2)) ;
//        -->Assert.assertFalse(boolean condition);
//        *// this will check condition is false or true --> if it is false your test will pass
//    note: it is not really suggested tu use since it is confusing, mostly used for negative scenario
//
//    WebDriverManager:It is a way te setup chromedriver(automation) up to date, so it does not need any chrome version update. Its pretty usefull.
//
//    Short cut: CTRL+ALT+L -->it makes your code organized
//    CTRL + F --> it will open search bar for finding element in website
//
//
//    CSS: is all about style, organizing the website.
//    We will be using cssSelector to find the element as one of the locator
//    note: "#" is used in cssSelector for ID attributes
//              "." is used in cssSeletor for Class attributes
//
//    WebElement element = driver.findElement(Bt.cssSelector("#checkbox")) --> id
//    WebElement element2 = driver.findElement(Bt.cssSelector(".checkbox")) --> class
//
//    WHAT I LEARNED TODAY:
//
//            -->How to apply WebDriverManager --> WebDriverManager.chromedriver().setup;
//-->How to work with real life scenarios:
//            -->Happy Path(Positive Login) Functionality (automation)
//            -->Happy Negative Login Functionality (automation)
//  -->How to and Where to use Thread.sleep() --> mostly before or after click(You need to be good observer)
//  -->How to validate ascending order and descending order tasks.(please watch class if you are confused)
//            -->How to validate two list (actual and expected) --> Collections.sort or Collections.reverse
//
//
//
//    RECAP: 2/21/2023
//
//    List<WebElement> --> Is all about finding and storing more than 1 elements
//
//    List<String> actualValues = new ArrayList();
//
//    List<String> expectedValues = new ArrayList();
//
//
//    List <WebElement> allValues = driver.findElements(By.xpath("//a[@id='brands']"))
//  for (int i=1; i<allVallues.size; i++){
//        actualValue.add(allVallues.get(i));
//        expectedValues.add(allValues.get(i))
//
//    }
//
//  Collections.sort(expectedValues);
//  Assert.assertEquals(actualValues,expectedValues)
//
//    Descending ORDER:
//            Collections.reverse(expectedValues)
//    {2,1,3,4} --> {4,3,1,2}
//    {1,2,3,4} --> sorted --> {4,3,2,1} --> reverse
//
//  Assert.assertEquals(actualValues,expectedValues)
//
//            -->Whenever the task asks you to do ascending or descending order-->
//
//            ==>Create 2 list (Actual, expected)
//      -->Loop Through the lists and add WebElements into the lists as GetText
//      -->If it is ascending --> You just need to Collections.sort(expectedValues) and Assert
//      -->If it is descending --> You just need to Collections.sort(expectedValues) and
//      Collections.reverse(expectedValues) then Assert
//
//    RECAP: 2/22/23
//    INTERVIEW QUESTION:
//
//            1-How do you handle drop-downs?
//    To be able to handle drop down in Selenium. (If the elements have "Select" tagName)
//            -->I find the location of the Select tagName element
//    WebElement country = driver.findElement(By.xpath("//div[@id='countryBox']"))-->BOX
//
//            -->I need to create an object from Select Class
//    Select country = new Select(countryBox)
//
//            -->You can start using the Select class methods:
//            ***country.selectByVisible("Turkey") --> this will select the option with text
//      **country.selectByValue("207") ; --> this will select the option with value
//       *country.selectByIndex(2); --> this will select option with index(index starts from 0);
//     ***country.getFirstSelectedOption(); -->it will provide the default selected option
//     ***country.getOptions();-->it will give you all the options from select WebElement.
//    NOTE: To be able to access these all options, you need to consider loops.
//
//
//
//    RECAP: 2/25/23
//
//    SELECT CLASS: Is all about dealing the dropdowns
//      **-->To be able to use Select Class --> The element "MUST HAVE" select tagName
//  *country.deselectByVisibleText("Turkey") -->This will deselect the option with text
//  *country.deselectByValue("207"); --> this will deselect the option with Value
//  *country.deselectByIndex(3); -->this will deselect the option by Index
//  *country.deselectAll(); --> this will deselect all the options were selected before
//
//
//
//    Interview Questions:
//
//            1-What kind of methods do you use to handle dropdowns with Select class?
//
//    NOTE: To be able to use these methods, you need to create object from Select Class:
//
//    Select select = new Select(location of Element);
//
//    *For every box you need Object because every box has different location.
//
//            -->select.getOptions;
//  -->select.getFirstSelectedOption;
//  -->select.selectByVisibleText;
//  -->select.selectByValue;
//  -->select.deselectByIndex;
//
//    ACTIONS: Is all about mouse functionality.
//
//            NOTE: You need to create an object, this object accepts "driver". One object will be enough to do all mouse actions.
//      --> Actions actions = new Actions (driver);
//    ACTIONS METHODS:
//            -->actions.contentClick(WebElement).perform(); --> You must provide "PERFORM" at the end --> right click
//    -->actions.doubleClick(WebElement).performm(); --> double click
//    -->actions.click(WebElement).perform();
//    -->actions.sendKeys(WebElement).perform();
//
//    STALE ELEMENT REFERENCE EXCEPTION: AND HOW TO DEAL WITH:
//
//    INTERVIEW QUESTION:
//            1-How to deal with No Such Element Exception? (please scroll up,it should be there)
//            2-How do you handle STALEELEMENTREFERENCE EXCEPTION?
//    I have different ways to handle this exception
//
//    FIRST: I know that STALEELEMENTREFERENCE exception is thrown once the DOM is not update, refresh etc.. fast.
//    So based on the scenario there are the actions I take:
//
//            1-I first think that it is a wait time issue then provide Thread.sleep before it happens
//   ***2-I need to "REINITIALIZE THE WEBELEMENT" that causing stale element exception (remembere orangebox)
//      3-I refresh page driver.navigate.refresh method.
//
//    ELEMENTINTERCEPTED EXCEPTION:
//
//    This exception happens when the element is not clickable ( it means the way that you found the element does not have button or tagname)
//
//  1-To be able to handle this, go and try to find the element with correct path.findElement
//  2-This exception happens when the element is not visible on the screen ( it means you need to scroll up or down to see the element on the screen)
//
//    -->Keys.Arrow UP
//    -->Keys.Arrow DOWN
//    -->actions.scrollByAmount(number,number) --> 50,50 ,100,100 ,200,200 , 400,400
//
//
//
//    RECAP: 2/26/2023
//
//            -> How to deal with STALEELEMENTENTERFERENCE exception **
//            ->Reassign the WebElement --> Thread.sleep()(Mostly) --> Driver.navigate.refresh(rarely)
//            --> Actions class --> Is a away to use mouse actions (functionality)
//  -->Actions actions = new Actions(driver);
// **actions.contentClick() --> right click
//   actions.doubleClick() -->double click
//   actions.dragAndDrop(source,target) --> drags and drops the element in a certain target
//   actions.clickAndHold(WebElement) --> Clicks and hold an element
// **actions.moveToElement(WebElement) --> it moves the mouse on the WebElement(Hover Over)
//   actions.release()-> releases WebElement that you are holding
//   actions.scrollByAmount(number1, number2)--> it scrolls based on X and Y coordinate
//***actions.perform() --> This is all about executing the actions
//    actions.sendKeys --> it does the same thing of WebElement sendKeys
//   actions.click() --> it clicks the element as WebElement does
//
//    INTERVIEW QUESTIONS:
//            1-Can you tell me about Actions class in Selenium?
//            -->It is and class of which we create and object in order to do more mouse actions while testing
//   2-Can you tell me the actions method you use in Selenium?
//            -->contentClick,dragAndDrop, moveToElement,clickAndHold,release,scrollByAmount, and all of these methods needs to be followed by perform method.
//            3-Can you tell me how you right click in Selenium?
//            -->I use Actions Class with ContentClick   method then Perform at the end
//
//
//    RECAP: 2/28/2023
//
//    JS Methods: It is a way to handle some actions that are not working in SELENIUM
//
//  -->Title --> return "document.title"
//            -->Click --> "arguments[0].click()",element
//  -->ScrollIntoView --> "arguments[0].scrollIntoView(true)",element
//    NOTE:If you get any question regarding JS --> Please do not forget to tell them
//    -->I store my JS methods in Browser Utils then calling from there.
//
//    INTERVIEW QUESTIONS:
//            *How do you handle the different tabs in automation?
//            *What is the difference between getWindowHandle and getWindowHandles?
//
//    GET WINDOW HANDLE/S --> This is a way to handle windows
//
//    String mainPageId = driver.getWindowHandle() --> This will return String pageID(single)
//
//    Set<String> allPagesID = driver.getWindowHandles --> This will return Set<String> pageIDs (multiple)
//
//    for(String id : allPagesID){
//        if(!id.equals(mainPageID)){
//            driver.switchTo.windows(id);
//            break;
//        }
//    }
//
//    RECAP: 3/1/2023
//
//    INTERVIEW QUESTIONS:
//            1-What is the difference between getWindowHandle and getWindowHandles?
//
//    getWindowHandle --> ReturnString(PageID)
//    getWindowHandles --> return Set<String> (AllPagesID)
//
//
//            2-How do you change the tabs? Can you clarify it?
//
//    You can change the tabs/windows with this logic:
//
//    Set<String> allPagesID = driver.getWindowHandles();
//      for(String id : allPagesID){
//        driver.switchTo.window(id);
//        if(driver.getTitle().contains(expectedTitle)){
//            break;
//        }
//    }
//
//    NOTE: To be honest, I love using Browser Utils class which has my reusable static method.
//    I store there and call whenever I need which makes my work easier and my code look cleaner.
//
//            3-In what condition do you get NOSUCHELEMENT ELEMENT EXCEPTION?
//
//            -->If the locator or path is wrong
//    -->If the element is dynamic(changing)
//    -->If there is a wait time issue
//    -->If there is another window that you need to switch your driver.
//
//            4-What is the difference between driver.close and driver.quit()?
//
//            -->Thats a good question that I apply specifically when I automate some windows opened during the testing.
//    -driver.close() --> will close the current window that driver is pointing.
//    -driver.quit() --> will close all the windows that were opened during the automation run
//
//    WHAT WE LEARNED TODAY:
//
//            -->IFRAME/FRAME --> It is html inside html
//      -->What is the purpose ?
//            --> Protection of Data (ads,video ads, documents)
//      -->How do we use it:
//            -->To be able to acces the data inside of iframe we need to switch our driver to iframe
//           *** -->driver.switchTo.frame(id or name)  -->provide id or name here
//            ** --> driver.switchTo.frame(WebElement) --> find the WebElement, then provide in here
//               -->driver.switchTo.frame(index) --> provide index number(never used)
//  --> ACTIONS className
//  -->GetWindowHandle/s concept
//  -->JS scrool method
//  -->How to handle NOSUCHELEMENT EXCEPTION with iframe
//  -->Parent-Child
//
//    RECAP:3/4/2023
//
//    INTERVIEW QUESTIONS:
//
//            1-What is frame/iframe? what do you know about frame/iframe?
//    It is a way to hide/protect some data (ads,documents,videos...etc)
//  2-How do you handle the elements are in iframes?
//    I have a selenium method that comes from driver
//    -->driver.switchTo(id or name) --> driver.switchTo.frame("Ahmet")
//            -->driver.switchTo.frame(WebElement) --> you need to find the location of frame.
//            -->driver.switchTo.frame(index)-->this is not really usefull
//    SHOWOFF: There is also ParentFrame() --> whitch goes to the previous frame.
//
//
//    NESTED FRAME:
//    Main HTML --> Codefish building main door(main entrance) --> first step
//    TOP-FRAME --> Codefish entrance --> second step
//    LEFT-FRAME --> Admin room
//    MIDDLE-FRAME --> Batch15 room --> third step
//    RIGHT-FRAME --> Batch16 room
//    BOTTOM-FRAME --> Other(ABC) company entrance
//
//  -->Parent Frame : It is a way to go to the previous Frame that you come from.
//            -->Example: If you are in the Middle Frame --> And if you say ParentFrame
//                      --> You will got to the Top-Frame
//                    --> If you are on Top Frame --> and if you say ParentFrame
//                      -->you will go to the Main HTML
//  -->Default Content : It is a away to go to the "ALL THE WAY MAIN HTML" no matter what.
//                    -->Example: If you are in the Middle Frame --> And if you say DefaultContent()
//                      -->you will go to the MAIN HTML
//
//  -->NOSUCHFRAME EXCEPTION: Whenever your frame location of value are wrong. It will throw this exception
//    How to handle: Check your frame location.
//            driver.switchTo.frame("top-right"); --> Correct, no exception
//      driver.switchTo.frame("tp-right"); --> NOSUCHFRAME EXCEPTION
//
//
//    //button[contains(@id,'promptBox')
//
//
//    RECAP:3/5/2023
//
//    NESTED FRAME: It is a way to handle more than 1 frame (ads,videos, documents)
//
//    MAIN HTML --> covers eveything
//    TOP FRAME --> top side of the page (html inside of html)
//
//        <html>
//
//    LEFT FRAME --> left side of the top frame
//
//          <html>
//
//    MIDDLE FRAME --> middle side of the top frame
//
//          <html>
//
//    RIGHT FRAME --> right side of the top frame
//
//          <html>
//    BOTTOM FRAME --> bottom side of the page
//            <html>
//
//
//    HOW TO SWITCH FRAME:
//
//    to be able to get the middle --> You need to switch your frame two times because this under 2 frames.
//
//    -->TOP FRAME --> MIDDLE FRAME --> Get the element value
//    driver.switchTo.frame("top-frame") --> driver.switchTo.frame("middle-frame") -->
//            element.getText(elementLocation)
//
//    To be able to getRIGHT txt -->
//
//            1- You need to get out from middle frame --> driver.switchTo.ParentFrame();
//
//    -->driver.switchTo.frame(frame-right);
//
//    You are in the Middle frame and want to get text From BOTTOM frame
//
//    1-driver.switchTo.ParentFrame()--> This one will make you go to the TOP FRAME
//    2-driver.switchTo.ParentFrame()--> This one will make you go to the MAIN HTML
//    3-driver.switchTo.frame("Bottom-Frame")--> This will make you go in the bottom frame
//    YOU CAN DO EXACTLY SAME ACTION WITH THIS:
//            1-driver.switchTo.DefaultContent()-->it will directly go to the main html(no matter what)
//      2-driver.switchTo.frame("Bottom-Frame");
//
//    ALERT INTERFACE: It is a way to handle pop-ups
//
//    1-How do you handle pop-ups?
//    Actually, there are different ways for different pop-up to handle.
//        -->JS Alert/pop-up --> Use alert interface and call some methods to handle this pop-up
//        -->HTML Alert/pop-up --> Just inspect and find the element then click it
//        -->OS(Operation System)  --> We can not hadnle it.
//            SHOWOFF: As much as I know there is a ROBOT class that handle this OS pop-ups.
//    I am a quick learner, so if you need this class for your framework. I am definettly open for it.
//    2-How do you handle JS alert specifically?
//            --> To be able to handle JS alert --> I would definettly need Alert interface from Selenium library
//        -->Alert alert = driver.switchTo.alert();
//    3-Can you tell me the methods you use to handle JS alerts/pop-up ?
//            alert.accept()-->click the "OK" button on the JS
//      alert.dismiss()-->click "CANCEL" button on the JS
//      alert.getText()-->get the text from "JS ALERT"
//            alert.sendKeys()-->sends the data to the JS alert
//
//    FILE UPLOAD: It is a way to upload file on the website to check the funcitonality of the button
//      --> Simply we just find the location of ChoseFile button and Send the location of file
//
//    WebElement chooseFileButton = driver.findElement(By.cssSelector(".upload_txt"));
//        chooseFileButton.sendKeys("C:\\Users\\Cory\\Desktop\\usa.png");
//
//    INTERVIEW QUESTION:
//            1-What is the difference between submit() and click() ?
//
//    submit works when you have type="submit" or if it is under "form" tagName
//
//    click works as long as its clickable
//
//      2- What is the difference between SoftAssert and HardAssert() ?
//    Both of them are really useful to do validation.
//    I personally like HardAssert because:
//            1-When it fails, it tells me the exact location of failure and with the informative description
//            2-When it fails, it stops executing the next line of code
//    SoftAssert Advantage:
//            1-When it fails, it keeps executing the next lines of code.(it is useful during regression)
//            2-You need to create an object from SoftAssert class
//
//      3- What do you know about assert.All method?
//            -->it is a method to activate your all softAssertions.Generraly, we put this at the end of execution
//        -->if you do not use assert.assertAll()-->Your test will pass all the time.(remember the Ahmets story)
//
//
//    RECAP: 3/7/2023
//
//            -->Setting Up your automation -->SetProperty("webdriver.chrome.driver","chromedriver.exe")
//  -->Maven Dependency --> These are the libraries that we download from MVN.repository
//  -->POM.xml  --> location for dependencies (you stored your Dependency inside of here)
//    -->Java-Selenium -->necessary to use Selenium method with Java
//  -->main method
//    -->Driver Methods:
//            -->get,navigate,navigate.to,refresh,back,forward
//      -->findElement,findElements
//      -->getWindowHandle,getWindowHandles
//      -->getTitle and getCurrentUrl
//
//    -->WebElement Methods:
//            -->getText --> SendKeys --> getAttribute --> IsDisplayed --> isSelected --> isEnabled
//      -->click
//    -->Locators:
//    ID--> NAME-->CLASSNAME-->LINKTEXT-->PARTIALLINKTEXT --> TAGNAME-->CSS-->XPATH
//    CSS: .==> clas attribute #--> id attribute
//    XPATH:
//    //TagName[@attribute='AttributeValue']
//    //TagName[.='TextValue'] ==>%100 match
//    //TagName[contains(text(),'TextValue')] --> looking for attribute contains
//    //TagName[contains(@attribute,'attributeValue')] --> looking for attribute contains
//    //TagName[@attribute='AttributeValue']//following-sibling::tagname
//    //TagName[@attribute='AttributeValue']//preceding-sibling::tagname
//    NOTE: Do not use any indexing for any element unless they are tables
//
//    LEVEL 2:
//    TESTNG: framework
//
//    -->@Test --> kind of our main method--> you can have as many @Test as you want in 1 class
//    -->Assert --> validation --> assertEquals(actual,expected) -->Assert.assertTrue(boolean condition) -->assertFalse(boolean condition)
//    -->priority --> it is all about the execution order of the test @Test(priority=1)
//    -->invocationCount --> It will run the same test as many times as you want. @Test(invocationCount=5)
//
//    SELECT CLASS: it is a way to handle dropdowns
//    -->Element must have "Select" tagname
//    -->Select referenceName = new Select(locationOfWebElement)   --> it means location of box
//
//    -->referenceName.selectByValue("textValue")
//            -->referenceName.selectByVisibleText("Value")
//            -->referenceName.selectByIndex(index)
//            -->referenceName.getFirstSelectedOption(); --> it will give you default value
//    -->referenceName.getOptions()-->will give you all the options dropdown
//
//    ACTION CLASS: It is a way to handle Mouse actions
//  --> Actions actions = new Actions(driver)  ;
//  -->actions.click --> Actions.doubleClick --> actions.dragAndDrop --> actions.sendKeys --> actions.clickAndHold , release
//  -->actions.moveToElement -->hoverOver --> scrollToElement
//  *--> ContextClick() --> right click
//    NOTE:To be able to make the action class methods work. You must use .Perform() at the end !
//    GetWindowHandle - GetWindowHandles : These are all about handling the windows (switching the windows)
//  -->You need to handle this otherwise you will get "NOSUCHELEMENTEXCEPTION"
//            -->GetWindowHandle -->return string PageID
//    GetWindowHandles --> returns SET<String> allPagesID
//
//    Set<String> allPagesId = driver.getWindowHandles;
//  for(String id: allPagesID){
//        driver.switchTo.window(id);
//        if(driver.getTitle.equals(title)){
//            break;
//        }
//    }
//
//    FRAME/IFRAME : thesea re all about protection for documents,ads,videos...etc(HTML inside HTML)
//  -->If you do not handle this frame, you will get"NOSUCHELEMENTEXCEPTION"
//
//    How to handle:
//
//            -->driver.switchTo.frame(id or name)
//            -->driver.switchTo.frame(WebElement)
//            -->driver.switchTo.frame(index) -->not suggested
//
//    NESTED FRAME: is all about more than 1 frame that covers the document, ads, videos
//
//    MAIN HTML
//    TOP FRAME
//    LEFT FRAME
//    MIDDLE FRAME
//    RIGHT FRAME
//    BOTTOM FRAME
//
//    NOTE: ParentFrame() --> it will go to the previous Frame
//    DefaultContent() --> it will go to the main HTML
//
//    ALERT CLASS: all about handling the pop-ups
//    -->JS Alert --> You need to create an alert interface
//    Alert alert = driver.switchTo.Alert;
//      -->alert.accept --> clicks ok
//      -->alert.dismiss --> clicks cancel
//      -->alert.getText --> gets the text
//      -->alert.sendKeys --> sends the data
//    NOTE: If you do not handle Alert pop-up --> you will get "UNHANDLED ALERTEXCEPTION"
//            -->HTML ALERT --> You just need to find the element and click
//
//    -->OS(Operations System) --> You cannot handle it. Robot class can do but I am not familiar
//    SOFT ASSERT: It is all about validation but little bit differet
//
//    -->SoftAssert needs an object to call the methods.
//    SoftAssert softAssert = new SoftAssert();
//    softAssert.assertEquals,true,False
//    NOTE: 1-When something fails, it keeps executing the next lines.(it does not throw and exception and stop the code)
//            2-To be able to activate softAssert methods, YOU MUST USE "ASSERTALL()" at the end
//    FILE-UPLOAD: It is all about uploading the file on the website to check the funcitonality of buttons.
//            -->We just need to find the location of "chooseFileButton" and send the location of document via sendKeys
//
//      chooseFileButton.sendKeys("/C:codefish/file/usa/png")
//
//    CONGRATULATIONS FOR COMPLETING LEVEL 2 AND WELCOME TO MY WORLD
//
//================================================================================================================================================================================
//
//    Welcome to LEVEL 3
//
//    POM(PAGE OBJECT MODEL) : it is a way to organize all the elements, pages, dependencies, tests etc ...
//            -->Int POM:
//            -->Every page will have their own classes with WebElements and Their methods
//    -->We will centralize all the WebElements and Methods in a specific area that makes look really :
//            -->easy to read
//      -->easy to find
//      -->professional
//      -->code efficiency
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
