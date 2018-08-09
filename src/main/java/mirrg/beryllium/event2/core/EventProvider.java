package mirrg.beryllium.event2.core;

import java.util.TreeMap;
import java.util.function.Consumer;

import mirrg.beryllium.event2.IEventProvider;
import mirrg.beryllium.event2.IRemover;

public abstract class EventProvider<L> implements IEventProvider<L>
{

	private TreeMap<Integer, L> listeners = new TreeMap<>();

	private int index = 0;

	/**
	 * リスナーをリスナーリストの末尾に追加します。
	 * 追加されたリスナーは必ずこれまでに追加されたリスナーよりも後に呼び出されます。
	 * 既に追加されているリスナーを追加しようとした場合、
	 * そのリスナーは多重に登録され一度のイベントで複数回呼び出されます。
	 *
	 * @return
	 * 		このRunnableを実行するとイベントの登録が解除されます。
	 */
	public IRemover register(L listener)
	{
		int index2 = index;
		listeners.put(index, listener);
		index++;
		return () -> listeners.remove(index2);
	}

	protected void fire(Consumer<L> acceptor)
	{
		for (L listener : listeners.values()) {
			acceptor.accept(listener);
		}
	}

}
