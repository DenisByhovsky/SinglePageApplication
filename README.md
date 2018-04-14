**Single Page Application**



**Types of uses:**
*   **Bookmaker**
*   **Admin**
*   **Client**
*   **Guest**


1.Xls file parse to List of Skill's object.
   - List<Skill> skills consists of two objets(Hard skills, Soft skills). 
   - Some of this objects have child List. 
   - All skills have such parametres as: row numb,col numb, name("String/text""), childList

2.This List send/convert to runner.json file

3. With handlebarse and js we make the view of our json file on html page.

4. Block view configuration we make with css

5. Our page has three buttons add/delete/change name.
   - With js and ajax request we send our data to servlet, which run methods( add new element to xls, delete element),and save all changes in xls;

6.After this our page get response and run handlebars function to build new menu(tree)


**Used technologies:**
*  Composite pattern
*  Servlets
*  JSP
*  Handlebars
*  Tomcat 8.5
*  Log4j2
*  POI   
*  Ajax

**Tests:**
*  JUnit
