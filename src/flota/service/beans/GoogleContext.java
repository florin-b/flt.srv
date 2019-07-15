package flota.service.beans;

import java.util.concurrent.TimeUnit;

import com.google.maps.GeoApiContext;

import flota.service.utils.Constants;

public class GoogleContext {

	private static GeoApiContext instance;

	private static GeoApiContext instance1;
	private static GeoApiContext instance2;
	private static GeoApiContext instance3;
	private static GeoApiContext instance4;
	private static GeoApiContext instance5;
	private static GeoApiContext instance6;
	private static GeoApiContext instance7;
	private static GeoApiContext instance8;

	private static GeoApiContext instance9;
	private static GeoApiContext instance10;
	private static GeoApiContext instance11;
	private static GeoApiContext instance12;
	private static GeoApiContext instance13;
	private static GeoApiContext instance14;
	private static GeoApiContext instance15;
	private static GeoApiContext instance16;

	private static GeoApiContext instance17;
	private static GeoApiContext instance18;
	private static GeoApiContext instance19;
	private static GeoApiContext instance20;
	private static GeoApiContext instance21;
	private static GeoApiContext instance22;
	private static GeoApiContext instance23;
	private static GeoApiContext instance24;

	private static GeoApiContext instance25;
	private static GeoApiContext instance26;
	private static GeoApiContext instance27;
	private static GeoApiContext instance28;
	private static GeoApiContext instance29;
	private static GeoApiContext instance30;

	private static GeoApiContext instance31;
	private static GeoApiContext instance32;
	private static GeoApiContext instance33;
	private static GeoApiContext instance34;
	private static GeoApiContext instance35;
	private static GeoApiContext instance36;
	private static GeoApiContext instance37;
	private static GeoApiContext instance38;
	private static GeoApiContext instance39;
	private static GeoApiContext instance40;
	private static GeoApiContext instance41;

	private static GeoApiContext instance42;
	private static GeoApiContext instance43;
	private static GeoApiContext instance44;
	private static GeoApiContext instance45;
	private static GeoApiContext instance46;
	private static GeoApiContext instance47;
	private static GeoApiContext instance48;
	private static GeoApiContext instance49;
	private static GeoApiContext instance50;
	private static GeoApiContext instance51;

	private static GeoApiContext instance52;
	private static GeoApiContext instance53;
	private static GeoApiContext instance54;
	private static GeoApiContext instance55;
	private static GeoApiContext instance56;

	private static GeoApiContext instance57;
	private static GeoApiContext instance58;
	private static GeoApiContext instance59;
	private static GeoApiContext instance60;
	private static GeoApiContext instance61;
	private static GeoApiContext instance62;
	
	private static GeoApiContext instanceKey;

	private GoogleContext() {

	}

	public static GeoApiContext getContext() {
		if (instance == null) {
			instance = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY);
			instance.setQueryRateLimit(2);
			instance.setRetryTimeout(0, TimeUnit.SECONDS);
			instance.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance;
	}

	public static GeoApiContext getContextKey() {
		if (instanceKey == null) {
			instanceKey = new GeoApiContext().setApiKey(Constants.GOOGLE_PAYED_KEY);
			instanceKey.setQueryRateLimit(2);
			instanceKey.setRetryTimeout(0, TimeUnit.SECONDS);
			instanceKey.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instanceKey;
	}		
	
	
	public static GeoApiContext getContext(int contextNumber) {

		System.out.println("context number: " + contextNumber);

		switch (contextNumber) {
		case 1:
			return getContext1();
		case 2:
			return getContext2();
		case 3:
			return getContext3();
		case 4:
			return getContext4();
		case 5:
			return getContext5();
		case 6:
			return getContext6();
		case 7:
			return getContext7();
		case 8:
			return getContext8();

		case 9:
			return getContext9();
		case 10:
			return getContext10();
		case 11:
			return getContext11();
		case 12:
			return getContext12();
		case 13:
			return getContext13();
		case 14:
			return getContext14();
		case 15:
			return getContext15();
		case 16:
			return getContext16();

		case 17:
			return getContext17();
		case 18:
			return getContext18();
		case 19:
			return getContext19();
		case 20:
			return getContext20();
		case 21:
			return getContext21();
		case 22:
			return getContext22();
		case 23:
			return getContext23();
		case 24:
			return getContext24();

		case 25:
			return getContext25();
		case 26:
			return getContext26();
		case 27:
			return getContext27();
		case 28:
			return getContext28();
		case 29:
			return getContext29();
		case 30:
			return getContext30();

		case 31:
			return getContext31();
		case 32:
			return getContext32();
		case 33:
			return getContext33();
		case 34:
			return getContext34();
		case 35:
			return getContext35();
		case 36:
			return getContext36();
		case 37:
			return getContext37();
		case 38:
			return getContext38();
		case 39:
			return getContext39();
		case 40:
			return getContext40();
		case 41:
			return getContext41();
		case 42:
			return getContext42();
		case 43:
			return getContext43();
		case 44:
			return getContext44();
		case 45:
			return getContext45();
		case 46:
			return getContext46();
		case 47:
			return getContext47();
		case 48:
			return getContext48();
		case 49:
			return getContext49();
		case 50:
			return getContext50();
		case 51:
			return getContext51();
		case 52:
			return getContext52();
		case 53:
			return getContext53();
		case 54:
			return getContext54();
		case 55:
			return getContext55();
		case 56:
			return getContext56();
		case 57:
			return getContext57();
		case 58:
			return getContext58();
		case 59:
			return getContext59();
		case 60:
			return getContext60();
		case 61:
			return getContext61();
		case 62:
			return getContext62();
		default:
			return getContext1();
		}
	}

	public static GeoApiContext getContext1() {

		if (instance1 == null) {
			instance1 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_01);
			instance1.setQueryRateLimit(2);
			instance1.setRetryTimeout(0, TimeUnit.SECONDS);
			instance1.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance1;
	}

	public static GeoApiContext getContext2() {

		if (instance2 == null) {
			instance2 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_02);
			instance2.setQueryRateLimit(2);
			instance2.setRetryTimeout(0, TimeUnit.SECONDS);
			instance2.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance2;
	}

	public static GeoApiContext getContext3() {

		if (instance3 == null) {
			instance3 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_03);
			instance3.setQueryRateLimit(2);
			instance3.setRetryTimeout(0, TimeUnit.SECONDS);
			instance3.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance3;
	}

	public static GeoApiContext getContext4() {

		if (instance4 == null) {
			instance4 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_04);
			instance4.setQueryRateLimit(2);
			instance4.setRetryTimeout(0, TimeUnit.SECONDS);
			instance4.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance4;
	}

	public static GeoApiContext getContext5() {

		if (instance5 == null) {
			instance5 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_05);
			instance5.setQueryRateLimit(2);
			instance5.setRetryTimeout(0, TimeUnit.SECONDS);
			instance5.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance5;
	}

	public static GeoApiContext getContext6() {

		if (instance6 == null) {
			instance6 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_06);
			instance6.setQueryRateLimit(2);
			instance6.setRetryTimeout(0, TimeUnit.SECONDS);
			instance6.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance6;
	}

	public static GeoApiContext getContext7() {

		if (instance7 == null) {
			instance7 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_07);
			instance7.setQueryRateLimit(2);
			instance7.setRetryTimeout(0, TimeUnit.SECONDS);
			instance7.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance7;
	}

	public static GeoApiContext getContext8() {

		if (instance8 == null) {
			instance8 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_08);
			instance8.setQueryRateLimit(2);
			instance8.setRetryTimeout(0, TimeUnit.SECONDS);
			instance8.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance8;
	}

	public static GeoApiContext getContext9() {

		if (instance9 == null) {
			instance9 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_09);
			instance9.setQueryRateLimit(2);
			instance9.setRetryTimeout(0, TimeUnit.SECONDS);
			instance9.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance9;
	}

	public static GeoApiContext getContext10() {

		if (instance10 == null) {
			instance10 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_10);
			instance10.setQueryRateLimit(2);
			instance10.setRetryTimeout(0, TimeUnit.SECONDS);
			instance10.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance10;
	}

	public static GeoApiContext getContext11() {

		if (instance11 == null) {
			instance11 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_11);
			instance11.setQueryRateLimit(2);
			instance11.setRetryTimeout(0, TimeUnit.SECONDS);
			instance11.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance11;
	}

	public static GeoApiContext getContext12() {

		if (instance12 == null) {
			instance12 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_12);
			instance12.setQueryRateLimit(2);
			instance12.setRetryTimeout(0, TimeUnit.SECONDS);
			instance12.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance12;
	}

	public static GeoApiContext getContext13() {

		if (instance13 == null) {
			instance13 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_13);
			instance13.setQueryRateLimit(2);
			instance13.setRetryTimeout(0, TimeUnit.SECONDS);
			instance13.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance13;
	}

	public static GeoApiContext getContext14() {

		if (instance14 == null) {
			instance14 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_14);
			instance14.setQueryRateLimit(2);
			instance14.setRetryTimeout(0, TimeUnit.SECONDS);
			instance14.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance14;
	}

	public static GeoApiContext getContext15() {

		if (instance15 == null) {
			instance15 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_15);
			instance15.setQueryRateLimit(2);
			instance15.setRetryTimeout(0, TimeUnit.SECONDS);
			instance15.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance15;
	}

	public static GeoApiContext getContext16() {

		if (instance16 == null) {
			instance16 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_16);
			instance16.setQueryRateLimit(2);
			instance16.setRetryTimeout(0, TimeUnit.SECONDS);
			instance16.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance16;
	}

	public static GeoApiContext getContext17() {

		if (instance17 == null) {
			instance17 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_17);
			instance17.setQueryRateLimit(2);
			instance17.setRetryTimeout(0, TimeUnit.SECONDS);
			instance17.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance17;
	}

	public static GeoApiContext getContext18() {

		if (instance18 == null) {
			instance18 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_18);
			instance18.setQueryRateLimit(2);
			instance18.setRetryTimeout(0, TimeUnit.SECONDS);
			instance18.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance18;
	}

	public static GeoApiContext getContext19() {

		if (instance19 == null) {
			instance19 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_19);
			instance19.setQueryRateLimit(2);
			instance19.setRetryTimeout(0, TimeUnit.SECONDS);
			instance19.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance19;
	}

	public static GeoApiContext getContext20() {

		if (instance20 == null) {
			instance20 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_20);
			instance20.setQueryRateLimit(2);
			instance20.setRetryTimeout(0, TimeUnit.SECONDS);
			instance20.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance20;
	}

	public static GeoApiContext getContext21() {

		if (instance21 == null) {
			instance21 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_21);
			instance21.setQueryRateLimit(2);
			instance21.setRetryTimeout(0, TimeUnit.SECONDS);
			instance21.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance21;
	}

	public static GeoApiContext getContext22() {

		if (instance22 == null) {
			instance22 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_22);
			instance22.setQueryRateLimit(2);
			instance22.setRetryTimeout(0, TimeUnit.SECONDS);
			instance22.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance22;
	}

	public static GeoApiContext getContext23() {

		if (instance23 == null) {
			instance23 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_23);
			instance23.setQueryRateLimit(2);
			instance23.setRetryTimeout(0, TimeUnit.SECONDS);
			instance23.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance23;
	}

	public static GeoApiContext getContext24() {

		if (instance24 == null) {
			instance24 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_24);
			instance24.setQueryRateLimit(2);
			instance24.setRetryTimeout(0, TimeUnit.SECONDS);
			instance24.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance24;
	}

	public static GeoApiContext getContext25() {

		if (instance25 == null) {
			instance25 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_25);
			instance25.setQueryRateLimit(2);
			instance25.setRetryTimeout(0, TimeUnit.SECONDS);
			instance25.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance25;
	}

	public static GeoApiContext getContext26() {

		if (instance26 == null) {
			instance26 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_26);
			instance26.setQueryRateLimit(2);
			instance26.setRetryTimeout(0, TimeUnit.SECONDS);
			instance26.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance26;
	}

	public static GeoApiContext getContext27() {

		if (instance27 == null) {
			instance27 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_27);
			instance27.setQueryRateLimit(2);
			instance27.setRetryTimeout(0, TimeUnit.SECONDS);
			instance27.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance27;
	}

	public static GeoApiContext getContext28() {

		if (instance28 == null) {
			instance28 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_28);
			instance28.setQueryRateLimit(2);
			instance28.setRetryTimeout(0, TimeUnit.SECONDS);
			instance28.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance28;
	}

	public static GeoApiContext getContext29() {

		if (instance29 == null) {
			instance29 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_29);
			instance29.setQueryRateLimit(2);
			instance29.setRetryTimeout(0, TimeUnit.SECONDS);
			instance29.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance29;
	}

	public static GeoApiContext getContext30() {

		if (instance30 == null) {
			instance30 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_30);
			instance30.setQueryRateLimit(2);
			instance30.setRetryTimeout(0, TimeUnit.SECONDS);
			instance30.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance30;
	}

	public static GeoApiContext getContext31() {

		if (instance31 == null) {
			instance31 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_31);
			instance31.setQueryRateLimit(2);
			instance31.setRetryTimeout(0, TimeUnit.SECONDS);
			instance31.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance31;
	}

	public static GeoApiContext getContext32() {

		if (instance32 == null) {
			instance32 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_32);
			instance32.setQueryRateLimit(2);
			instance32.setRetryTimeout(0, TimeUnit.SECONDS);
			instance32.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance32;
	}

	public static GeoApiContext getContext33() {

		if (instance33 == null) {
			instance33 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_33);
			instance33.setQueryRateLimit(2);
			instance33.setRetryTimeout(0, TimeUnit.SECONDS);
			instance33.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance33;
	}

	public static GeoApiContext getContext34() {

		if (instance34 == null) {
			instance34 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_34);
			instance34.setQueryRateLimit(2);
			instance34.setRetryTimeout(0, TimeUnit.SECONDS);
			instance34.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance34;
	}

	public static GeoApiContext getContext35() {

		if (instance35 == null) {
			instance35 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_35);
			instance35.setQueryRateLimit(2);
			instance35.setRetryTimeout(0, TimeUnit.SECONDS);
			instance35.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance35;
	}

	public static GeoApiContext getContext36() {

		if (instance36 == null) {
			instance36 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_36);
			instance36.setQueryRateLimit(2);
			instance36.setRetryTimeout(0, TimeUnit.SECONDS);
			instance36.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance36;
	}

	public static GeoApiContext getContext37() {

		if (instance37 == null) {
			instance37 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_37);
			instance37.setQueryRateLimit(2);
			instance37.setRetryTimeout(0, TimeUnit.SECONDS);
			instance37.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance37;
	}

	public static GeoApiContext getContext38() {

		if (instance38 == null) {
			instance38 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_38);
			instance38.setQueryRateLimit(2);
			instance38.setRetryTimeout(0, TimeUnit.SECONDS);
			instance38.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance38;
	}

	public static GeoApiContext getContext39() {

		if (instance39 == null) {
			instance39 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_39);
			instance39.setQueryRateLimit(2);
			instance39.setRetryTimeout(0, TimeUnit.SECONDS);
			instance39.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance39;
	}

	public static GeoApiContext getContext40() {

		if (instance40 == null) {
			instance40 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_40);
			instance40.setQueryRateLimit(2);
			instance40.setRetryTimeout(0, TimeUnit.SECONDS);
			instance40.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance40;
	}

	public static GeoApiContext getContext41() {

		if (instance41 == null) {
			instance41 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_41);
			instance41.setQueryRateLimit(2);
			instance41.setRetryTimeout(0, TimeUnit.SECONDS);
			instance41.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance41;
	}

	public static GeoApiContext getContext42() {

		if (instance42 == null) {
			instance42 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_42);
			instance42.setQueryRateLimit(2);
			instance42.setRetryTimeout(0, TimeUnit.SECONDS);
			instance42.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance42;
	}

	public static GeoApiContext getContext43() {

		if (instance43 == null) {
			instance43 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_43);
			instance43.setQueryRateLimit(2);
			instance43.setRetryTimeout(0, TimeUnit.SECONDS);
			instance43.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance43;
	}

	public static GeoApiContext getContext44() {

		if (instance44 == null) {
			instance44 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_44);
			instance44.setQueryRateLimit(2);
			instance44.setRetryTimeout(0, TimeUnit.SECONDS);
			instance44.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance44;
	}

	public static GeoApiContext getContext45() {

		if (instance45 == null) {
			instance45 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_45);
			instance45.setQueryRateLimit(2);
			instance45.setRetryTimeout(0, TimeUnit.SECONDS);
			instance45.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance45;
	}

	public static GeoApiContext getContext46() {

		if (instance46 == null) {
			instance46 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_46);
			instance46.setQueryRateLimit(2);
			instance46.setRetryTimeout(0, TimeUnit.SECONDS);
			instance46.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance46;
	}

	public static GeoApiContext getContext47() {

		if (instance47 == null) {
			instance47 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_47);
			instance47.setQueryRateLimit(2);
			instance47.setRetryTimeout(0, TimeUnit.SECONDS);
			instance47.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance47;
	}

	public static GeoApiContext getContext48() {

		if (instance48 == null) {
			instance48 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_48);
			instance48.setQueryRateLimit(2);
			instance48.setRetryTimeout(0, TimeUnit.SECONDS);
			instance48.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance48;
	}

	public static GeoApiContext getContext49() {

		if (instance49 == null) {
			instance49 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_49);
			instance49.setQueryRateLimit(2);
			instance49.setRetryTimeout(0, TimeUnit.SECONDS);
			instance49.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance49;
	}

	public static GeoApiContext getContext50() {

		if (instance50 == null) {
			instance50 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_50);
			instance50.setQueryRateLimit(2);
			instance50.setRetryTimeout(0, TimeUnit.SECONDS);
			instance50.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance50;
	}

	public static GeoApiContext getContext51() {

		if (instance51 == null) {
			instance51 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_51);
			instance51.setQueryRateLimit(2);
			instance51.setRetryTimeout(0, TimeUnit.SECONDS);
			instance51.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance51;
	}

	public static GeoApiContext getContext52() {

		if (instance52 == null) {
			instance52 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_52);
			instance52.setQueryRateLimit(2);
			instance52.setRetryTimeout(0, TimeUnit.SECONDS);
			instance52.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance52;
	}

	public static GeoApiContext getContext53() {

		if (instance53 == null) {
			instance53 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_53);
			instance53.setQueryRateLimit(2);
			instance53.setRetryTimeout(0, TimeUnit.SECONDS);
			instance53.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance53;
	}

	public static GeoApiContext getContext54() {

		if (instance54 == null) {
			instance54 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_54);
			instance54.setQueryRateLimit(2);
			instance54.setRetryTimeout(0, TimeUnit.SECONDS);
			instance54.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance54;
	}

	public static GeoApiContext getContext55() {

		if (instance55 == null) {
			instance55 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_55);
			instance55.setQueryRateLimit(2);
			instance55.setRetryTimeout(0, TimeUnit.SECONDS);
			instance55.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance55;
	}

	public static GeoApiContext getContext56() {

		if (instance56 == null) {
			instance56 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_56);
			instance56.setQueryRateLimit(2);
			instance56.setRetryTimeout(0, TimeUnit.SECONDS);
			instance56.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance56;
	}

	public static GeoApiContext getContext57() {

		if (instance57 == null) {
			instance57 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_57);
			instance57.setQueryRateLimit(2);
			instance57.setRetryTimeout(0, TimeUnit.SECONDS);
			instance57.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance57;
	}

	public static GeoApiContext getContext58() {

		if (instance58 == null) {
			instance58 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_58);
			instance58.setQueryRateLimit(2);
			instance58.setRetryTimeout(0, TimeUnit.SECONDS);
			instance58.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance58;
	}

	public static GeoApiContext getContext59() {

		if (instance59 == null) {
			instance59 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_59);
			instance59.setQueryRateLimit(2);
			instance59.setRetryTimeout(0, TimeUnit.SECONDS);
			instance59.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance59;
	}

	public static GeoApiContext getContext60() {

		if (instance60 == null) {
			instance60 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_60);
			instance60.setQueryRateLimit(2);
			instance60.setRetryTimeout(0, TimeUnit.SECONDS);
			instance60.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance60;
	}

	public static GeoApiContext getContext61() {

		if (instance61 == null) {
			instance61 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_61);
			instance61.setQueryRateLimit(2);
			instance61.setRetryTimeout(0, TimeUnit.SECONDS);
			instance61.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance61;
	}

	public static GeoApiContext getContext62() {

		if (instance62 == null) {
			instance62 = new GeoApiContext().setApiKey(Constants.GOOGLE_MAPS_API_KEY_62);
			instance62.setQueryRateLimit(2);
			instance62.setRetryTimeout(0, TimeUnit.SECONDS);
			instance62.setConnectTimeout(1, TimeUnit.SECONDS);

		}

		return instance62;
	}

}
