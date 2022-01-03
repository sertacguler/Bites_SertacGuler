package sertac_guler;

import java.util.HashSet;
import java.util.Set;

public class ZoneCounter implements ZoneCounterInterface {

	private Set<String> _Set = new HashSet<String>();
	private MapInterface _Map;

	public void Init(MapInterface map) throws Exception {
		this._Map = map;
		System.out.println("Map'te " + Solve() + " tane bolge vardir.");
	}

	public int Solve() throws Exception {

		int[] aPoint = new int[2];
		int countofZone = 0;

		aPoint = findFirstZonePoint(); // ilk bolge noktasi bulundu

		while (!(aPoint[0] < 0) && !(aPoint[1] < 0)) {
			paintAreasofZone(aPoint[0], aPoint[1]); // bolgenin, bulunan ilk noktasindan diger noktalarini bulma
			countofZone++;
//			System.out.print("\nFirst Clean Point is : " + aPoint[0] + "," + aPoint[1] + "\n_Sets : " + _Set + "\n"	+ "Count of Zone : " + countofZone + "\n");
			aPoint = findFirstZonePoint(); // baska bir bolge noktasi bulundu
		}

		return countofZone;
	}

	// ilk bolge noktasi
	public int[] findFirstZonePoint() {

		int[] firstPoint_Array = new int[2];
		String firstPoint_Sting = "";
		int xAxis = 0; // width
		int yAxis = 0; // height

		while (yAxis >= 0) {
			while (xAxis >= 0) {

				firstPoint_Sting = yAxis + "," + xAxis;
				try {
					if (!_Set.contains(firstPoint_Sting) && !_Map.IsBorder(xAxis, yAxis)) {

						_Set.add(firstPoint_Sting);

						firstPoint_Array[0] = yAxis;
						firstPoint_Array[1] = xAxis;
						return firstPoint_Array;
					}
				} catch (Exception e) {
					xAxis = 0;
					break; // x ekseninden harita disina cikti
				}
				xAxis += 1;
			}
			try {
				_Map.IsBorder(xAxis, yAxis);
			} catch (Exception e1) {
				break; // y ekseninden harita disina cikti
			}
			yAxis += 1;
		}

		firstPoint_Array[0] = -1;
		firstPoint_Array[1] = -1;
		return firstPoint_Array;
	}

	public void paintAreasofZone(int _yAxis, int _xAxis) {

		String aZonePoint = "";

		for (int y = _yAxis - 1; y <= _yAxis + 1; y++) {
			for (int x = _xAxis - 1; x <= _xAxis + 1; x++) {

				if (!pointValidate(y, _yAxis, x, _xAxis)) {
					continue;
				}
				try {
					aZonePoint = y + "," + x;
					if (!_Set.contains(aZonePoint) && !_Map.IsBorder(x, y)) {
						_Set.add(aZonePoint);
						paintAreasofZone(y, x);
					}
				} catch (Exception e) {
					continue; // harita disina cikti
				}
			}
		}
	}

	private Boolean pointValidate(int _y, int yAxis, int _x, int xAxis) {
		if (_y < 0 || _x < 0)
			return Boolean.FALSE;
		if (_y == yAxis && _x == xAxis)
			return Boolean.FALSE;
		if (_y == yAxis - 1 && _x == xAxis - 1)
			return Boolean.FALSE;
		if (_y == yAxis - 1 && _x == xAxis + 1)
			return Boolean.FALSE;
		if (_y == yAxis + 1 && _x == xAxis + 1)
			return Boolean.FALSE;
		if (_y == yAxis + 1 && _x == xAxis - 1)
			return Boolean.FALSE;
		return Boolean.TRUE;
	}

}
