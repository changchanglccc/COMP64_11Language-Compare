(defun diagnostic_system(symptoms disease)
(if (find (car symptoms) '(list fever cough soreThroat tiredness headaches))
    (if(not(find 'influenza disease))(push 'influenza disease)))
    
(if (find (car symptoms) '(list muscleAches chills rash tiredness soreThroat))
    (if(not(find 'aids disease))(push 'aids disease)))
    
(if (find (car symptoms) '(list joint_pain stomach_pain nausea dark_urine itchy_skin))
    (if(not(find 'hepatitisC disease))(push 'hepatitisC disease)))
    
(if (find (car symptoms) '(list mood_swings food_aversions abdominal_bloating a_missed_period sore breasts))   
    (if(not(find 'pregnancy disease))(push 'pregnancy disease)))
   
(if (not(null symptoms))    
(diagnostic_system (cdr symptoms) disease)   
(print disease)))

(setq symptoms '(mood_swings food_aversions abdominal_bloating a_missed_period sore breasts))
(setq disease '())
(print "Dignose Result:")
(diagnostic_system symptoms '())
