Varje ValidityCheck, t.ex. "isPersonNumber",  är en klass som implementerar interfacet "ValidityCheck". För att skapa fler Validitychecks är det bara att skapa en ny klass som implementerar interfacet Validitycheck, och implementera metoden "isValid()".

isPersonNumber godkänner strängar på formen "19820411-2380".

isRegistrationNumber godkänner strängar på formerna "SAS23K" och "SAS234".

ValidityChecker innehåller en lista av ValidityChecks. Man kan lägga till eller ta bort ValidityChecks från ValidityChecker.