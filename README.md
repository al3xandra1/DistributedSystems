# DistributedSystems 


# Σύνδεση νέας βάσης δεδομένων postgreSql στο intelij με αυτά τα στοιχεία (από την βάση που έφτιαξα στο render):

Host: dpg-cu2jdpqj1k6c73cmqisg-a.oregon-postgres.render.com
Port: 5432
User: user
Password: WVWSBRSBoQ8T9Orlymo8LZOWxQQ7CTsf

Από τα databases επιλέγετε το volunteer_management -> all schemas

Αν θέλετε να κάνετε αλλαγές στη βάση δεδομένων πρέπει να έχετε κατεβασμένο το pgAdmin, εκεί επιλέγετε register server και συνδέεστε στην βάση render με τα παραπάνω στοιχεία 

Με την εκτέλεση της εφαρμογής δημιουργούνται οι πίνακες event, registration, role, user_roles στο public schemas
Ο πίνακας user δεν μπορεί να δημιουργηθεί επειδή είναι δεσμευμένη λέξη στο postgresql (εκκρεμεί διόρθωση)










