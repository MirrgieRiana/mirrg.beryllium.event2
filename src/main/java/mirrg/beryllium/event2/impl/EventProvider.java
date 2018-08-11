package mirrg.beryllium.event2.impl;

import java.util.TreeMap;
import java.util.function.Consumer;

import mirrg.beryllium.event2.IEventProvider;
import mirrg.beryllium.event2.IRemover;

public abstract class EventProvider<L> implements IEventProvider<L>
{

	private TreeMap<Integer, L> listeners = new TreeMap<>();

	private int index = 0;

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
