symptom(influenza,fever).
symptom(influenza,chills).
symptom(influenza,cough).
symptom(influenza,soreThroat).
symptom(influenza,runny).
symptom(influenza,muscleAches).
symptom(influenza,headaches).
symptom(influenza,fatigue).
symptom(influenza,vomiting).
symptom(influenza,diarrhea).
symptom(aids,fever).
symptom(aids,chills).
symptom(aids,rash).
symptom(aids,nightSweats).
symptom(aids,muscleAches).
symptom(aids,soreThroat).
symptom(aids,fatigue).
symptom(aids,mouthUlcers).
symptom(aids,swollenLymphNodes).
symptom(pregnancy,foodAversions).
symptom(pregnancy,moodSwings).
symptom(pregnancy,abdominalBloating).
symptom(pregnancy,frequentUrination).
symptom(pregnancy,fatigue).
symptom(pregnancy,soreBreasts).
symptom(pregnancy,lightBleeding).
symptom(pregnancy,nausea).
symptom(pregnancy,missedPeriod).
symptom(pregnancy,highBodyTemperature).
symptom(hepatitis_c,tired).
symptom(hepatitis_c,soreMuscles).
symptom(hepatitis_c,jointPain).
symptom(hepatitis_c,fever).
symptom(hepatitis_c,nausea).
symptom(hepatitis_c,stomachPain).
symptom(hepatitis_c,itchySkin).
symptom(hepatitis_c,darkUrine).
disease([S],D):-symptom(D,S).
disease([T|H],D):-symptom(D,T),disease(H,D). 

/**
 we input a list of symptoms the patient have, the prolog will output the disases patient may have.
 For example, disease([chills,fever],D). and D will output 'influenza','aids'.
 so more symptoms you input, more precise the disease the system answer you.
*/

