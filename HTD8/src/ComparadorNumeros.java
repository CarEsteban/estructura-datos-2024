import java.util.Comparator;

/**
 * @author moises.alonso
 *
 */
public class ComparadorNumeros<K> implements Comparator<K> {

	@Override
	public int compare(K o1, K o2) {
		if ((int)o1 == (int)o2)
			return 0;
		else if ((int)o1 > (int)o2)
			return -1;
		else 
			return 1;
	}

}