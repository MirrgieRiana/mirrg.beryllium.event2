package mirrg.beryllium.event2;

public class EventProviderRunnable extends EventProvider<Runnable> implements Runnable
{

	@Override
	public void run()
	{
		fire(l -> l.run());
	}

}
