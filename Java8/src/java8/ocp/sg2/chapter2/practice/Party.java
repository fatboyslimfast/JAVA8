package java8.ocp.sg2.chapter2.practice;

public class Party {
	
	interface eat {
		void eat();
	}
	
	
	interface drink {
		void drink();
	}

	
	interface merry {
		void beMerry();
	}
	
	public class MyParty implements eat, drink, merry {

		
		
		
		
		@Override
		public void beMerry() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void drink() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void eat() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	public static void main (String[] args) {
		Party myParty = new Party() {
			class otherParty implements eat, drink, merry {

				@Override
				public void beMerry() {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void drink() {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void eat() {
					// TODO Auto-generated method stub
					
				}
				
			}
		};

	}
}
