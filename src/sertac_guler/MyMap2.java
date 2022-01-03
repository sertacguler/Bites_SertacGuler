package sertac_guler;

public class MyMap2 implements MapInterface {

	int[][] _Map2DArray = null;

	Dimension dim = new Dimension(6, 7);

	public MyMap2() {

		SetSize(dim);

		try {
			ClearBorder(0, 0);
			SetBorder(1, 0);
			ClearBorder(2, 0);
			ClearBorder(3, 0);
			ClearBorder(4, 0);
			SetBorder(5, 0);

			ClearBorder(0, 1);
			SetBorder(1, 1);
			SetBorder(2, 1);
			SetBorder(3, 1);
			SetBorder(4, 1);
			SetBorder(5, 1);

			ClearBorder(0, 2);
			SetBorder(1, 2);
			ClearBorder(2, 2);
			SetBorder(3, 2);
			ClearBorder(4, 2);
			SetBorder(5, 2);

			ClearBorder(0, 3);
			SetBorder(1, 3);
			SetBorder(2, 3);
			SetBorder(3, 3);
			SetBorder(4, 3);
			SetBorder(5, 3);

			ClearBorder(0, 4);
			SetBorder(1, 4);
			ClearBorder(2, 4);
			SetBorder(3, 4);
			ClearBorder(4, 4);
			SetBorder(5, 4);

			ClearBorder(0, 5);
			SetBorder(1, 5);
			SetBorder(2, 5);
			SetBorder(3, 5);
			SetBorder(4, 5);
			SetBorder(5, 5);

			ClearBorder(0, 6);
			SetBorder(1, 6);
			ClearBorder(2, 6);
			ClearBorder(3, 6);
			ClearBorder(4, 6);
			SetBorder(5, 6);

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
	public void SetBorder(int x, int y) throws Exception {
		if (!dim.CheckWithin(x, y)) {
			throw new Exception("Out of Map");
		}
		_Map2DArray[y][x] = 1;
	}

	@Override
	public void ClearBorder(int x, int y) throws Exception {
		if (!dim.CheckWithin(x, y)) {
			throw new Exception("Out of Map");
		}
		_Map2DArray[y][x] = 0;
	}

	@Override
	public boolean IsBorder(int x, int y) throws Exception {
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
