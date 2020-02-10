package aula13.Ex1;

public enum TipoLocalidade {
	CIDADE {
		@Override
		public String toString() {
			return "Cidade";
		}
	},
	VILA {
		@Override
		public String toString() {
			return "Vila";
		}
	},
	ALDEIA {
		@Override
		public String toString() {
			return "Aldeia";
		}
	};
}
