# DistributedSystems 

# PSQL Command:
PGPASSWORD=aJorvQJPYPoVuL6IewlkeltXH6HzPg9b psql -h dpg-cumcdl8gph6c73df4lig-a.oregon-postgres.render.com -U volunteerdb_ru2d_user volunteerdb_ru2Host: dpg-cu2jdpqj1k6c73cmqisg-a.oregon-postgres.render.com

# Οδηγίες σύνδεσης της βάσης δεδομένων postgreSql στο intelij 

Χρησιμοποιήθηκε το εργαλείο pgAdmin για τη χειροκίνητη δημιουργία της βάσης με την εντολή: CREATE DATABASE volunteer_management;
Ύστερα, για την προβολή των πινάκων και των δεδομένων της βάσης, η βάση δεδομένων συνδέθηκε μέσω 
του μενού Database στο IntelliJ με τα στοιχεία σύνδεσης από το Render. 
Όπου:
• Host: dpg-cumcdl8gph6c73df4lig-a.oregon-postgres.render.com
• User: volunteerdb_ru2d_user
• Password: aJorvQJPYPoVuL6IewlkeltXH6HzPg9b
• Port: 5432


Από τα databases επιλέγετε το volunteer_management -> all schemas
Με την εκτέλεση της εφαρμογής δημιουργούνται οι πίνακες στο public schemas: event, organization, registration, role, user_roles, users.

Αν θέλετε να κάνετε αλλαγές στη βάση δεδομένων πρέπει να έχετε κατεβασμένο το pgAdmin, εκεί επιλέγετε register server και συνδέεστε στην βάση render με τα παραπάνω στοιχεία 

# Bίντεο εκτέλεσης της εφαρμογής
Υπάρχει screen recording με την εκτέλεση της εφαρμογής στο αρχείο VideoRun.mp4 ή στον σύνδεσμο:
https://screenapp.io/app/#/shared/4T5e4ejX6y










