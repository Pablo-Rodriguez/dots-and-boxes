
## Resources
  + Información muy detallada sobre dots and boxes y q-learning[aquí.](http://www.csc.kth.se/utbildning/kandidatexjobb/datateknik/2010/rapport/arvidsson_oskar_OCH_wallgren_linus_K10047.pdf)
  + Ejemplo sencillo que explica muy bien el algoritmo [aquí](http://mnemstudio.org/path-finding-q-learning-tutorial.htm)

## Terminology
Terminología rara que conviene tener clara antes de nada.
  + Reinforcement learning is a subset of the machine learning techniques. These techniques learn through trial and error in search of an optimal solution.
  + Q-learning: a reinforcement learning algorithm
  + Feedback: an action generates feedback from the environment. The feedback can be either positive or negative. The feedback is used in the Q-learning algorithm for estimating how good an action is. The term reward is used for positive feedback and negative feedback is called punishment.

  + Learning rate: is a paramenter in the q-learning algorithm, describing the relationship between old and new memories. A high value means that new memories take precedence over old memories and vice versa. A value of zero means that nothing will be learnt.

  + Discount factor: The discount factor is a parameter in the q-learning algorithm, affecting the importace of future feedback. A high discount factor increases the importance of future feedback.

## Consideraciones
  + Resulta difícil que este algoritmo pueda ser útil en el caso que nos ocupa puesto que requeriría una cantidad ingente de memoria (que además haría muy lento el algoritmo) y mucho entrenamiento para alcanzar un nivel de juego decente.
  + Además, aunque sí tiene en cuenta cómo juega el adversario, no aporta mucho más a lo que ya consigue minimax.
