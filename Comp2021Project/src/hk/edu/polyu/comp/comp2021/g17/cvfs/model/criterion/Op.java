package hk.edu.polyu.comp.comp2021.g17.cvfs.model.criterion;

public enum Op{
	contains,
	equals,
	G,//greater
	GE,//greater or equal
	L,LE,E,NE,
	not_contains,
	AND, OR,
	NOT_AND, NOT_OR,
	not_equals;
	public Op negate() {
		switch (this) {
			
		case contains:
			return not_contains;
		case E:
			return NE;
		case G:
			return L;
		case GE:
			return NE;
		case L:
			return G;
		case LE:
			return GE;
		case NE:
			return E;
		case equals:
			return not_equals;
		case not_contains:
			return contains;
		case not_equals:
			return equals;
		case OR:
			return NOT_OR;
		case AND:
			return NOT_AND;
		case NOT_OR:
			return OR;
		case NOT_AND:
			return NOT_AND;
		default:
			//never reached
			return null;
		}
		
	}
}
