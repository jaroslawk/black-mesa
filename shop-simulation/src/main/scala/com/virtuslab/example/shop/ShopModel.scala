package com.virtuslab.example.shop

import com.virtuslab.blackmesa.model.space.Grid
import com.virtuslab.blackmesa.model.Agent
import com.virtuslab.blackmesa.model.BaseScheduler
import com.virtuslab.blackmesa.model.Model

case class ShopModel(grid: Grid[Agent]) extends Model {

  def withAgents(agents: List[Agent]): ShopModel = {
    agents.foreach(agent => grid.placeAgent(agent, agent.pos))
    ShopModel(grid)
  }

  override def schedule: BaseScheduler = new BaseScheduler(this)

  override def step(): Unit = {
    grid.getAllAgents.foreach(a => a.step(this))
  }

}
