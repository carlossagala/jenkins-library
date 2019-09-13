def inputString(int number){
    return input ( message : "Ingrese un String para la ejecucion de la etapa N* ${number}",
     parameters: [[$class: 'TextParameterDefinition', defaultValue: 'fail', description: "si ingresa fail la ejecucion n* ${number} fallara", name: 'input']] )    
}

def ExecPipe (int number, boolean reintento = false){
                  try {
                      if(!reintento){
                         echo "####################### EMPEZO LA EJECUCION N* ${number}"
                      }else{
                         echo "####################### REINTENTO LA EJECUCION N* ${number}"
                      }
                      def userInput =  inputString(number)
                      echo (userInput)
            
                      if ( userInput == 'fail'){
                            echo "####################### ERROR EN LA EJECUCION N* ${number}: INGRESASTE FAIL"
                            error "############## INGRESASTE FAIL LA EJECUCION N* ${number} FALLO";
                        }
                
                      echo "####################### TERMINO LA EJECUCION N* ${number}"
              
                     }catch (exc) {
                        def Continuar = input id: "REINTENTAR LA EJECUCION N* ${number}", message: 'Quiere reintentar ejecutar este paso?', parameters: [[$class: 'BooleanParameterDefinition', defaultValue: false, description: 'Este paso te permite validar si quiere reintentar', name: 'Confirme que esta descuerdo con reintentar']]
                        if(Continuar){   
                            ExecPipe(number, true)
                        }else{
                            error "ROMPIO LA EJECUCION N* ${number} Y SE DECIDIO NO REINTENTAR"
                        }
                    }
                }


