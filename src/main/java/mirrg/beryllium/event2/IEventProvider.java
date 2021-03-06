package mirrg.beryllium.event2;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import mirrg.beryllium.event2.impl.EventProviderBiConsumer;
import mirrg.beryllium.event2.impl.EventProviderConsumer;
import mirrg.beryllium.event2.impl.EventProviderRunnable;

/**
 * 単一の種類のイベントが流れるイベントプロバイダーです。
 * このイベントプロバイダーはmirrg.beryllium.eventのものと比較して、
 * 複数種類のイベントを統合的に扱うことができない代わりに、
 * 簡潔で高速なイベント処理を提供します。
 * また、イベントのクラスにとらわれない自由なイベントの定義ができます。
 */
public interface IEventProvider<L>
{

	/**
	 * リスナーをリスナーリストの末尾に追加します。
	 * 追加されたリスナーは必ずこれまでに追加されたリスナーよりも後に呼び出されます。
	 * 既に追加されているリスナーを追加しようとした場合、
	 * そのリスナーは多重に登録され一度のイベントで複数回呼び出されます。
	 *
	 * @return
	 * 		これを実行するとイベントの登録が解除されます。
	 */
	public IRemover register(L listener);

	public L trigger();

	//

	public static IEventProvider<Runnable> runnable()
	{
		return new EventProviderRunnable();
	}

	public static <E> IEventProvider<Consumer<E>> consumer()
	{
		return new EventProviderConsumer<>();
	}

	public static <E1, E2> IEventProvider<BiConsumer<E1, E2>> biConsumer()
	{
		return new EventProviderBiConsumer<>();
	}

}
