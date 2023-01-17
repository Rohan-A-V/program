# program
## cloud

### 1. Students details
_Object : Student_    

* field : Student Name , Data type : text    
* Field Label: USN (Length 10), Data Type: Text, provide an example USN as Help Text, make it as Required Field and Don’t allow Duplicate Values and make 
it as Case Insensitive.   
* Field Label: Section (Length 1), Data Type: Text, make it as Required Field.   
* Field Label: Semester (Length 1, Decimal Place 0), Data Type: Number, make it as Required Field.   
* Field Label: CGPA (Length 2, Decimal Places 2), Data Type: Number, make it 
as Required Field.  

_Validation rule_ 
* Student Name Validation : NOT (REGEX (Name,"[a-z A-Z]+[a-z A-Z]+"))
* Semester Validation  :  OR (Semester__c >8, Semester__c <=0)
* CGPA Validation :   CGPA__c > 10 
* USN Validation :   NOT(REGEX(USN__c,"[1-5]{1} +[A-Z]{2} + [0-9]{2} +[A-Z]{2} + [0-9]{3}"))


### 2. online cart
_Object : Cart_

* Field Label: Item Name, Data Type: Text Area, make it as Required Field. 
* Field Label: Category, Data Type: Picklist, click radio button in front of Enter values, with each value separated by a new line value are: Books, Electronics & 
Accessories, Furniture & Home Appliances, Fashion – Men, Fashion – Women, Fashion – Kids, Footwear and Others. Make it as Required Field and Restrict the values to the values in the picklist. 
* Field Label: Quantity, Data Type: Number, make it as Required Field. 
* Field Label: Price, Data Type: Currency (Length 16, Decimal Places 2), Make it as Required Field.


### 3. Faculty details
_object : Faculty_


* Field Label: ID (Length 10), Data Type: Text, provide an example ID as Help Text, make it as Required Field, don’t allow Duplicate Values, make it as Case Insensitive and Set this field as the unique record identifier from an external system 
* Field Label: Salary, Data Type: Currency (Length 16, Decimal Places 2), Make it as Required Field

_Validation rule_ 

* Name Validation :  NOT (REGEX (Name,” [a-z] [A-Z] + [ a-z] [A-Z] +”))


### 4. Flight details
##### _object : Flight_

* Field Label: Source, Data Type: Text Area, make it as Required Field. 
* Field Label: Destination, Data Type: Text Area, make it as Required Field. 
* Field Label: Departure Timing, Data Type: Date/Time, make it as Required Field.

 _Validation rule_ 

* Date Time should be in Range : Departure_Timing__c<NOW ()
* Source and destination Checking : Source__c = Destination__c 

##### _object : Status_

* Field Label: Flight Name, Data Type: Master-Detail Relationship, Related to: Flight. 
 Sharing Setting: Read-Only. Leave the defaults and save. 
* Master – Detail relationship is provided to enter status only to the existing flights. 
* Field Label: Flight Status, Data Type: Picklist, click radio button in front of Enter 
values, with each value separated by a new line. 
* Values are: Arrived, Cancelled, Delayed and Departed. 

