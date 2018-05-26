package mirrg.beryllium.event2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public abstract class EventProvider<L>
{

	protected Collection<L> listeners = new ArrayList<>();

	/**
	 * リスナーをリスナーリストの末尾に追加します。
	 * 追加されたリスナーは必ずこれまでに追加されたリスナーよりも後に呼び出されます。
	 * 既に追加されているリスナーを追加しようとした場合、
	 * そのリスナーは多重に登録され一度のイベントで複数回呼び出されます。
	 */
	public void register(L listener)
	{
		listeners.add(listener);
	}

	/**
	 * リスナーリストに登録されているリスナーのうち、
	 * 指定のリスナーと同一のインスタンスであるものをすべて削除します。
	 */
	public void remove(L listener)
	{
		listeners.removeIf(l -> l == listener);
	}

	protected void fire(Consumer<L> acceptor)
	{
		for (L listener : listeners) {
			acceptor.accept(listener);
		}
	}

}
