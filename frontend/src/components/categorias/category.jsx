import React from 'react'
import "./category.css"
import ImageConversivel from "../../assets/carFerrariCaliforniaT2014Red1.jpg"
import ImageCoupe from "../../assets/carBMW-M440i.jpg"
import ImageEsportivo from "../../assets/carBugattiChiron.jpg"
import ImageSedan from "../../assets/carPorschePanameraTurbo.jpg"

function Category() {
  return (
    
    <div className='categorySection'>
      <h3 className='categoryTitle'>Buscar por categoria de carro</h3>

      <div className="categoryContainer">
        <div className="categoryCard">
          <div className="box">
            <div className='contentFront'>
              <img src={ImageConversivel} alt="" className='img'/>
              <h4 className='text1'>Conversível</h4>
              <h6 className='text2'>807.105 Carros</h6>
            </div>
          
            <div className="contentBx">
              <div className="contentBack">
                <h4 className='text3'>Conversível</h4>
                <p className='text4'>Lorem ipsum dolor sit, amet consectetur adipisicing elit. At consequatur maxime ab corporis, explicabo eaque quia accusantium. Atque rerum fugiat aspernatur fugit cumque? Autem, quasi. Quod consequuntur quisquam a ea.</p>
              </div>
            </div>
          </div>
        </div>

        <div className="categoryCard">
          <div className="box">
            <div className='contentFront'>
              <img src={ImageCoupe} alt="" className='img'/>
              <h4 className='text1'>Coupé</h4>
              <h6 className='text2'>807.105 Carros</h6>
            </div>
          
            <div className="contentBx">
              <div className="contentBack">
                <h4 className='text3'>Coupé</h4>
                <p className='text4'>Lorem ipsum dolor sit, amet consectetur adipisicing elit. At consequatur maxime ab corporis, explicabo eaque quia accusantium. Atque rerum fugiat aspernatur fugit cumque? Autem, quasi. Quod consequuntur quisquam a ea.</p>
              </div>
            </div>
          </div>
        </div>

        <div className="categoryCard">
          <div className="box">
            <div className='contentFront'>
              <img src={ImageEsportivo} alt="" className='img'/>
              <h4 className='text1'>Esportivo</h4>
              <h6 className='text2'>807.105 Carros</h6>
            </div>
          
            <div className="contentBx">
              <div className="contentBack">
                <h4 className='text3'>Esportivo</h4>
                <p className='text4'>Lorem ipsum dolor sit, amet consectetur adipisicing elit. At consequatur maxime ab corporis, explicabo eaque quia accusantium. Atque rerum fugiat aspernatur fugit cumque? Autem, quasi. Quod consequuntur quisquam a ea.</p>
              </div>
            </div>
          </div>
        </div>

        <div className="categoryCard">
          <div className="box">
            <div className='contentFront'>
              <img src={ImageSedan} alt="" className='img'/>
              <h4 className='text1'>Sedan</h4>
              <h6 className='text2'>807.105 Carros</h6>
            </div>
          
            <div className="contentBx">
              <div className="contentBack">
                <h4 className='text3'>Sedan</h4>
                <p className='text4'>Lorem ipsum dolor sit, amet consectetur adipisicing elit. At consequatur maxime ab corporis, explicabo eaque quia accusantium. Atque rerum fugiat aspernatur fugit cumque? Autem, quasi. Quod consequuntur quisquam a ea.</p>
              </div>
            </div>
          </div>
        </div> 
      </div> 
    </div>
  )
}

export default Category
