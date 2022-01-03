package sertac_guler;

public class MyMap3 implements MapInterface {

	int[][] _Map2DArray = null;

	Dimension dim = new Dimension(6, 7); // (width,height)

	public MyMap3() {

		SetSize(dim);

		try {// (width,height)
			ClearBorder(0, 0);
			ClearBorder(1, 0);
			SetBorder(2, 0);
			ClearBorder(3, 0);
			ClearBorder(4, 0);
			ClearBorder(5, 0);

			ClearBorder(0, 1);
			ClearBorder(1, 1);
			ClearBorder(2, 1);
			SetBorder(3, 1);
			ClearBorder(4, 1);
			ClearBorder(5, 1);

			SetBorder(0, 2);
			SetBorder(1, 2);
			SetBorder(2, 2);
			SetBorder(3, 2);
			ClearBorder(4, 2);
			ClearBorder(5, 2);

			ClearBorder(0, 3);
			ClearBorder(1, 3);
			SetBorder(2, 3);
			ClearBorder(3, 3);
			ClearBorder(4, 3);
			SetBorder(5, 3);

			ClearBorder(0, 4);
			SetBorder(1, 4);
			ClearBorder(2, 4);
			SetBorder(3, 4);
			SetBorder(4, 4);
			ClearBorder(5, 4);

			SetBorder(0, 5);
			ClearBorder(1, 5);
			ClearBorder(2, 5);
			SetBorder(3, 5);
			ClearBorder(4, 5);
			ClearBorder(5, 5);

			ClearBorder(0, 6);
			ClearBorder(1, 6);
			ClearBorder(2, 6);
			SetBorder(3, 6);
			ClearBorder(4, 6);
			ClearBorder(5, 6);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Show();
		System.out.print("\n\n");
		GetSize(dim);
		System.out.print("\n\n");
	}

	@Override
	public void SetSize(Dimension dim) {
		_Map2DArray = new int[dim.height][dim.width];
	}

	@Override
	public void GetSize(Dimension dim) {
		System.out.print("Map Width : " + dim.width + ", Height : " + dim.height);
	}

	@Override
	public void SetBorder(int x, int y) throws Exception {// (width,height)
		if (!dim.CheckWithin(x, y)) {
			throw new Exception("Out of Map");
		}
		_Map2DArray[y][x] = 1;
	}

	@Override
	public void ClearBorder(int x, int y) throws Exception {// (width,height)
		if (!dim.CheckWithin(x, y)) {
			throw new Exception("Out of Map");
		}
		_Map2DArray[y][x] = 0;
	}

	@Override
	public boolean IsBorder(int x, int y) throws Exception {// (width,height)
		if (dim.CheckWithin(x, y)) {
			return _Map2DArray[y][x] == 1;
		}
		throw new Exception("Out of Map");
	}

	@Override
	public void Show() {
		for (int i = 0; i < _Map2DArray.length; i++) {
			System.out.print("\n");
			for (int j = 0; j < _Map2DArray[i].length; j++) {
				System.out.print(_Map2DArray[i][j] + " ");
			}
		}
	}

}
