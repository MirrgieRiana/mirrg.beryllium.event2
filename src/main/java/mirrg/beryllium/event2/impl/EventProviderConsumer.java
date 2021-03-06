package mirrg.beryllium.event2.impl;

import java.util.function.Consumer;

public class EventProviderConsumer<E> extends EventProvider<Consumer<E>>
{

	@Override
	public Consumer<E> trigger()
	{
		return (e) -> fire(l -> l.accept(e));
	}

}
