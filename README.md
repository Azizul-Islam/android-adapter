# android-adapter

## Gradel dependences


allprojects {

		repositories {	
		
			...			
			maven { url 'https://jitpack.io' 
			
			}	
			
		}		
	}
  
  

dependencies 
       {
       
	        compile 'com.github.Azizul-Islam:android-adapter:0.1.0'	
		
	}
	
**Create an adapter flowing below code**

**Kotlin format**

> class UserAdapter : BaseAdapter<User> {
  
    override fun isEqual(leftItem: User, rightItem: User): Boolean {
        return leftItem.name.equals(rightItem.name)
    }

    override fun newViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<User> {
        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        return UserHolder(view)
    }

    private inner class UserHolder(itemView: View) : BaseViewHolder<User>(itemView), View.OnClickListener {
        private var userName: TextView
        init {
            userName = itemView.findViewById(R.id.name)
            userName.setOnClickListener(this)
        }

        override fun bind(item: User) {
            userName.text = item.name
        }

        override fun onClick(v: View?) {
            itemClickListener.onItemClick(v!!, getItem(adapterPosition))
        }
    }

}

**Your Activity or Fragemtn format**

> class MainActivity : AppCompatActivity(), BaseListener<User> {


    lateinit var recyclerView : RecyclerView
    lateinit var userAdapter : UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rv)
        userAdapter = UserAdapter(this)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userAdapter
        userAdapter.itemClickListener = this
    }

    override fun onItemClick(view: View, item: User) {
        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(view: View, position: Int) {

    }

    override fun onItemLongClick(view: View, item: User) {

    }
}

Replace **User** with your own model class
