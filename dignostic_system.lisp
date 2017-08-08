(defun diagnostic_system(symptoms aids influenza hepatitisC pregnancy)

(if (find (car symptoms) '(list fever cough soreThroat tiredness headaches))
    (setf (disease-matched influenza) (+ (disease-matched influenza) 1)))  
    
(if (find (car symptoms) '(list muscleAches chills rash tiredness soreThroat))
    (setf (disease-matched aids) (+ (disease-matched aids) 1)))
    
(if (find (car symptoms) '(list joint_pain stomach_pain nausea dark_urine itchy_skin))
    (setf (disease-matched hepatitisC) (+ (disease-matched hepatitisC) 1)))
    
(if (find (car symptoms) '(list mood_swings food_aversions abdominal_bloating a_missed_period sore breasts))   
    (setf (disease-matched pregnancy) (+ (disease-matched pregnancy) 1)))
   
(if (not(null symptoms))    
(diagnostic_system (cdr symptoms) aids influenza hepatitisC pregnancy)   
))


(defstruct disease name matched) 
(setq aids 
      (make-disease :name "Aids" :matched 0)) 
(setq influenza 
      (make-disease :name "Influenza" :matched 0)) 
(setq hepatitisC 
      (make-disease :name "HepatitisC" :matched 0)) 
(setq pregnancy 
      (make-disease :name "Pregnancy" :matched 0)) 


(setq symptoms '(fever mood_swings soreThroat joint_pain food_aversions))
(print "Dignose Result:")
(diagnostic_system symptoms aids influenza hepatitisC pregnancy)

(print influenza)
(print aids)
(print hepatitisC)
(print pregnancy)
