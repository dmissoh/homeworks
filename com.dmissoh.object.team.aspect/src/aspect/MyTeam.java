package aspect;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import base com.dmissoh.rcp.mail.MessagePopupAction;

public team class MyTeam {

	protected class MyRole playedBy MessagePopupAction {

		Map<String, String> cache = new HashMap<String, String>();

		public void logger(){
			Date now = new Date();
			System.out.println(">> The Open Message Action has been called at [" + DateFormat.getDateTimeInstance().format(now) + "]");
		}
		logger <- before run;

		@SuppressWarnings("basecall")
		callin String generateMessage(String name) {
			String greeting = cache.get(name);
			if(greeting == null){
				System.out.println("The greeting for '" + name + "' is not in the cache, run the long lasting process to get.");
				greeting = base.generateMessage(name);
				cache.put(name, greeting);
			}
			System.out.println("The greeting for '" + name + "' is already in the cache, just use it");
			return greeting;
		}
		@SuppressWarnings("decapsulation")
		generateMessage <- replace generateMessage;

	}
}
