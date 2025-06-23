package Practica2;
import Practica1.Ejercicio8.Queue;

import java.util.Random;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());
	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}


	public int contarHojas() {
	   int cant = 0;
	   if (this.isLeaf()){
		   return 1;
	   }
	   if (this.hasLeftChild()){
		   cant += this.leftChild.contarHojas();
	   }
	   if (this.hasRightChild()){
		   cant += this.rightChild.contarHojas();
	   }

		return cant;
	}

	public BinaryTree<T> espejo() {
		//creo el nuevo arbol donde voy a cargar los datos espejados, el "(this.data)" es para guardar la raiz, en la raiz.
		BinaryTree<T> ArbolEspejo = new BinaryTree<T>(this.data);

		//si mi arbol tiene hijo derecho...
		if (this.hasRightChild()) {
			//entonces le add al hijo izquierdo del ArbolEspejo, llamando recursivamente al metodo .espejo, desde el hijo derecho
			ArbolEspejo.addLeftChild(this.rightChild.espejo());
		}

		//si mi arbol tiene hijo izquierdo...
		if (this.hasLeftChild()) {
			//entonces le add al hijo derecho del ArbolEspejo, llamando recursivamente al metodo .espejo, desde el hijo izquierdo
			ArbolEspejo.addRightChild(this.leftChild.espejo());
		}

		return ArbolEspejo;
	}


	// 0<=n<=m
	public void entreNiveles(int n, int m) {
		//si los niveles no tienen sentido O el arbol esta vacio retorno...
		if (n > m || this.isEmpty()) return;

		//guardo los nodos que estoy recorriendo.
		Queue<BinaryTree<T>> queue = new Queue<>();
		//guardo los niveles de cada nodo.
		Queue<Integer> levels = new Queue<>();

		//inicializo la cola con la raiz
		queue.enqueue(this);
		//la raiz esta en el nivel 0, asi que lo inicializo con 0
		levels.enqueue(0);


		//meto todos los nodos en la cola, y cuando la proceso si cumplen la condicion los imprimo;
		//mientras haya nodos por recorrer
		while (!queue.isEmpty()) {
			//saco (.dequeue) de la cola el nodo actual(current), y guardo el NODO ACTUAL en current
			BinaryTree<T> current = queue.dequeue();
			//saco (.dequeue) de la cola el numero de nivel actual, y guardo el NIVEL ACTUAL en level
			int level = levels.dequeue();

			//si el nivel esta entre los parametros ingresados
			if (level >= n && level <= m) {
				//lo imprimo
				System.out.print(current.getData() + " ");
			}

			//si el NIVEL ACTUAL es menor al parametro ingresado, significa que todavia tengo niveles que recorrer
			if (level < m) {
				//si el NODO ACTUAL tiene hijo izquierdo
				if (current.hasLeftChild()) {
					//agrego el nodo del hijo izquierdo del NODO ACTUAL a la cola
					queue.enqueue(current.getLeftChild());
					//y le sumo al nivel por que bajamos un nivel
					levels.enqueue(level + 1);
				}
				//si el NODO ACTUAL tiene hijo derecho
				if (current.hasRightChild()) {
					//agrego el nodo del hijo izquierdo del NODO ACTUAL a la cola
					queue.enqueue(current.getRightChild());
					//y le sumo al nivel por que bajamos un nivel
					levels.enqueue(level + 1);
				}
			}
		}
	}

	// Métod para generar un árbol binario aleatorio con Integer




}

