
disease(influenza,fever).
disease(influenza,chills).
disease(influenza,cough).
disease(influenza,soreThroat).
disease(influenza,runny).
disease(influenza,muscleAches).
disease(influenza,headaches).
disease(influenza,fatigue).
disease(influenza,vomiting).
disease(influenza,diarrhea).
disease(aids,fever).
disease(aids,chills).
disease(aids,rash).
disease(aids,nightSweats).
disease(aids,muscleAches).
disease(aids,soreThroat).
disease(aids,fatigue).
disease(aids,mouthUlcers).
disease(aids,swollenLymphNodes).
disease(pregnancy,foodAversions).
disease(pregnancy,moodSwings).
disease(pregnancy,abdominalBloating).
disease(pregnancy,frequentUrination).
disease(pregnancy,fatigue).
disease(pregnancy,soreBreasts).
disease(pregnancy,lightBleeding).
disease(pregnancy,nausea).
disease(pregnancy,missedPeriod).
disease(pregnancy,highBodyTemperature).
disease(hepatitis_c,tired).
disease(hepatitis_c,soreMuscles).
disease(hepatitis_c,jointPain).
disease(hepatitis_c,fever).
disease(hepatitis_c,nausea).
disease(hepatitis_c,stomachPain).
disease(hepatitis_c,itchySkin).
disease(hepatitis_c,darkUrine).

/* When you want to find out the disease you get, just use the queries(if symptons is more than 1) to get the result. */
/* The more symtons you describe correctly, the specific disease result you get. Here is an example */
/* ?- disease(X,chills),disease(X,rash). */
/* X = aids. */




