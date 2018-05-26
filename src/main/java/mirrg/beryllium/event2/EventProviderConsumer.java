package mirrg.beryllium.event2;

import java.util.function.Consumer;

public class EventProviderConsumer<E> extends EventProvider<Consumer<E>> implements Consumer<E>
{

	@Override
	public void accept(E event)
	{
		fire(l -> l.accept(event));
	}

}
