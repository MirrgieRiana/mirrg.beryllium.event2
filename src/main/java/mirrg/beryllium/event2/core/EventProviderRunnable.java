package mirrg.beryllium.event2.core;

public class EventProviderRunnable extends EventProvider<Runnable>
{

	@Override
	public Runnable trigger()
	{
		return () -> fire(l -> l.run());
	}

}
