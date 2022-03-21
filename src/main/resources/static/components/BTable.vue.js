Vue.component("BTable", {

    props: {
      headers: {
          type: Array,
          default: () => []
      },
      
      caption: String,
      url: String,
      sortBy: String
    },
          
    data () {
		return {
			pageSize: 20,
			page: 0,
			sortKey: this.sortBy,
			reverse: (this.sort === "DESC"),
			list: []
		}
	},
	
	created(){
		this.load();
	},
	
	methods: {
		sortBy(field) {
			if(field === this.sortKey)
				this.reverse = !this.reverse;
			this.sortKey = field;			
		},
		
		load() {
			const route = this.url + 
				"?page" + this.page + 
				"&size" + this.pageSize +
				"&"
			axios.get(route)
			.then((response) => {
				this.list = response.data;
			});
		}
	},

    template:
    `<div class="table-responsive-sm">
      <table class="table table-sm table-striped table-hover">
       <caption if="caption">{{ caption }}</caption>
        <thead>
            <tr>
                <th v-for="(header, idx) in headers"
                	:width="header.width">
                   <a href="#" v-if="header.sort === true"
                   	  @click="sortBy(header.field)">
                    {{ header.title }}
                    <span v-if="sortKey === header.field">
	                    <span v-if="reverse" class="material-icons">
							arrow_drop_up
						</span>
						<span v-else class="material-icons">
							arrow_drop_down
						</span>
					</span>
                   </a>
                   <span v-else>{{ header.title | capitalize }}</span>
                </th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="item in list">
                <td v-for="header in headers" 
                	:scope="header.scope ? 'row' : ''" >
                    {{ item[header.field] }}
                </td>
            </tr>
        </tbody>
        <tfoot>
        	<tr>
        		<th :colspan="headers.length" class="container">
	        		<div clas="row">
	        			<div class="col">
		        			<select class="form-select" 
		        				v-model="pageSize" 
		        				aria-label="Quantidade de itens por página">
							  <option value="20">20</option>
							  <option value="40">40</option>
							  <option value="60">60</option>
							  <option value="80">80</option>
							  <option value="100">100</option>
							</select>
						</div>
						<div class="col"></div>
						<div class="col-4">
							<nav aria-label="Paginação da tabela">
							  <ul class="pagination">
							    <li class="page-item">
							    	<a class="page-link" href="#" aria-label="Previous">
							        	<span aria-hidden="true">&laquo;</span>
							        </a>
							    </li>
							    <li class="page-item"><a class="page-link" href="#">1</a></li>
							    <li class="page-item"><a class="page-link" href="#">2</a></li>
							    <li class="page-item"><a class="page-link" href="#">3</a></li>
							    <li class="page-item">
							    	<a class="page-link" href="#" aria-label="Next">
        								<span aria-hidden="true">&raquo;</span>
      								</a>				    
							    </li>
							  </ul>
							</nav>
						</div>
					</div>
        		</th>
        	</tr>
        </tfoot>
      </table>
    </div>`
});