# Chemical Inventory
### Author Christian Murphy

## Overview
This application is designed to allow lab managers to easily create a EHS and OSHA compliant data inventory of their chemicals.

It has primary objectives
1. Be EHS and OSHA compliant (requires specific data to be stored)
2. Use simple and intuitive CRUD operations for managing inventory

Future goals
* Be able to export to CSV format for easy submission
* Use a web base database (DbPedia or Freebase) to autocomplete chemicals based on name or CAS number

## Use Case
Lab coordinator Bob want to inventory for OSHA report
1. Open app
2. Add a lab `Main Lab`
3. Click to add chemical
4. Enter name `Sodium Bicarbonate`
5. Enter CAS number `144-55-8`
6. Enter Quantity `500 grams`
7. Save
8. Click to add another chemical
9. Enter name `Carbonic Acid`
10. Enter CAS number `463-79-6`
11. Enter Quantity `500 milliliters`
12. Save
13. Mistake was made
14. Edit `Carbonic Acid`
15. Quantity `1500 milliliters`
16. Save

## Technologies
* Android Application
* Material Theme
* Realm Db for persistence
