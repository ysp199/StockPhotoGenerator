import React, { useState } from 'react';
import './App.css';
import ImageGenerator from './components/ImageGenerator';
import ChatComponent from './components/ChatComponent';
import RecipeGenerator from './components/RecipeGenerator';

function App() {
  const [activeTab, setActiveTab] = useState('image-generator');
  const handleTabChang = (tab) => {
    // alert(tab)
    setActiveTab(tab);
  }
  return (
    <div className="App">
      <button className={activeTab === 'image-generator' ? 'active' : ''} 
      onClick={() => handleTabChang('image-generator')}>Image Generator</button>

      <button className={activeTab === 'chat' ? 'active' : ''}
       onClick={() => handleTabChang('chat')}>Chat</button>

      <button className={activeTab === 'recipe-generator' ? 'active' : ''}
      onClick={() => handleTabChang('recipe-generator')}>Recipe Generator</button>
      
      <div>
        {activeTab === 'image-generator' && <ImageGenerator/>}
        {activeTab === 'chat' && <ChatComponent/>}
        {activeTab === 'recipe-generator' && <RecipeGenerator/>}
      </div>
    </div>
  );
}

export default App;
