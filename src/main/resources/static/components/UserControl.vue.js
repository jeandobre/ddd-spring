Vue.component("UserControl", {
	
	props: ["user", "userName", "avatar", "role"],
	
	computed: {
		maxHeigth() {
			return 600
		}
	},
	
	template: 
	`<div>
		<v-divider vertical dark></v-divider>
						
	<v-menu
	    offset-y
	    :close-on-content-click="false"
	    :max-height="maxHeigth">
	    
	    <template v-slot:activator="{ on }">	    	
			<v-btn		        
		        text		        
		        v-on="on"
		      >
		        <span style="color: #353434">{{ user }}</span>
				<v-avatar size="36px" class="ml-2">		
					<img :src="avatar" alt="Avatar" />
				</v-avatar>
			</v-btn>			
		</template>		
		
		<v-card max-width="300"> 
		 
		  	<v-row class="ma-2">      
	      	  <v-avatar size="36px" class="mt-3">		
				<img :src="avatar" alt="Avatar" />
			  </v-avatar>	                          
	          <div class="ml-3 mt-2">
	          	<div class="text-subtitle-2 font-weight-bold">{{ userName }}</div>
	          	<span class="text-subtitle-2">{{ role }}</span>
	          </div>
	        </v-row>	          
	      	<v-divider></v-divider>
	      <v-card-text>
	      
	        <v-list dense>	                      
	        
	          <v-list-item link>                  
	            <v-list-item-icon>
	              <v-icon>mdi-key</v-icon>
	            </v-list-item-icon>
	            <v-list-item-content>Alterar senha pessoal</v-list-item-content>
	          </v-list-item>
	          
	          <v-list-item link>
	            <v-list-item-icon>
	              <v-icon>mdi-view-dashboard-outline</v-icon>
	            </v-list-item-icon>                
	            <v-list-item-content>Preferências</v-list-item-content>
	          </v-list-item>
	        </v-list>
	      </v-card-text>              
	    </v-card>
		
    </v-menu>
    
    <v-btn icon small ml-2 color="teal accent-3">
		<v-icon>mdi-logout</v-icon>
	</v-btn>
    </div>`
});