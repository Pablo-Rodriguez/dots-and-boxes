
compile = javac -classpath build -d build

all: exec
exec: compile
	cd build && java Test
compile: dir src/Test.java build/GameManager.class
	$(compile) src/Test.java
build/GameManager.class: src/GameManager.java build/Box.class build/Edge.class build/Machine.class
	$(compile) src/GameManager.java
build/Box.class: src/Box.java
	$(compile) src/Box.java
build/Edge.class: src/Edge.java
	$(compile) src/Edge.java
build/Machine.class: src/Machine.java build/QLearning.class build/Minimax.class
	$(compile) src/Machine.java
build/QLearning.class: src/QLearning.java build/StateActionPair.class build/Edge.class build/Box.class
	$(compile) src/QLearning.java
build/Minimax.class: src/Minimax.java build/Edge.class build/Box.class
	$(compile) src/Minimax.java
build/StateActionPair.class: src/StateActionPair.java build/Edge.class
	$(compile) src/StateActionPair.java
dir:
	mkdir -p build
