# DistributedSystems 
# Αλλαγές που έκανα στο τελευταίο αρχείο

Στο αρχείο pom.xml προσθεσα τα dependencies για mysql και στο application.properties τα configurations για mysql και hibernate.

όπου spring.datasource.password=  ->ο κωδικός που έχετε στο mysql

Στο mysql έφτιαξα μία βάση δεδομένων (CREATE DATABASE volunteer_management;)
Από το δεξιά μενού του intelij σύνδεσα τη βάση δεδομένων

Στην κλάση event προσθεσα την παράμετρο organizationId που έλεγε ότι λείπει
Στο registration repository διόρθωσα το τυπογραφικό που υπήρχε

Έφτιαξα ένα αρχείο data.sql με ενδεικτικά δεδομένα για τους πίνακες που δημιουργούνται (δεν εκτελείται επειδή δεν τρέχει όλο το πρόγραμμα)
Κατά την εκτέλεση του προγράμματος δημιουργούνται αυτόματα οι πίνακες στην βάση δεδομένων(event, registration, role, user, user_roles) και οι αντίστοιχες στήλες τους.
Μετά από ένα σημείο ενώ γίνεται εκτέλεση, δεν εμφανίζει κάτι άλλο στο output και η εκτέλεση δεν τελειώνει..
